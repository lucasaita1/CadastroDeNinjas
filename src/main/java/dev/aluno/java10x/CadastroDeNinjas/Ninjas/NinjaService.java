package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar ninjas do Banco de Dados
    public List<NinjaModel> listarNinja(){
        return ninjaRepository.findAll();
    }

    //Listar todos ninjas por ID
    public NinjaModel listarNinjasPorId(Long id){
       Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
       return ninjaPorId.orElse(null);
    }

    //Criar ninjas
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Atualizar Ninja
    public NinjaModel atualizarNinja (Long id, NinjaModel ninjaAtualizado) {
        if (ninjaRepository.existsById(id)) {
            ninjaAtualizado.setId(id);
            return ninjaRepository.save(ninjaAtualizado);
        }
        return null;
    }

    //Deletar ninja (tem que ser um metodo void)
    public void deletarNinjaId (Long id){
       ninjaRepository.deleteById(id);
    }
}
