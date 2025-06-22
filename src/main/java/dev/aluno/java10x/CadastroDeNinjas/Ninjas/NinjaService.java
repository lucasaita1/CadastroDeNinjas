package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
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
    public NinjaModel criarNinja (NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }
}
