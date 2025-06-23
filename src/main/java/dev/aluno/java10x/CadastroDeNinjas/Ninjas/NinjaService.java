package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar ninjas do Banco de Dados
    public List<NinjaDTO> listarNinja(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }

    //Listar todos ninjas por ID
    public NinjaDTO listarNinjasPorId(Long id){
       Optional<NinjaModel> ninjaPorId = ninjaRepository.findById(id);
       return ninjaPorId.map(ninjaMapper::map).orElse(null);
    }

    //Criar ninjas
    public NinjaDTO criarNinja (NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(ninjaModel);
    }

    //Atualizar Ninja
    public NinjaDTO atualizarNinja (Long id, NinjaDTO ninjaDTO) {
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaMapper.map(ninjaDTO);
            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }

    //Deletar ninja (tem que ser um metodo void)
    public void deletarNinjaId (Long id){
       ninjaRepository.deleteById(id);
    }
}
