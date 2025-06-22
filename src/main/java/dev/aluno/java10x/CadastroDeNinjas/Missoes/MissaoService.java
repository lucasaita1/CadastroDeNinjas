package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import dev.aluno.java10x.CadastroDeNinjas.Ninjas.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    private MissaoRepository missaoRepository;

    public MissaoService(MissaoRepository missaoRepository) {
        this.missaoRepository = missaoRepository;
    }

    //listar missoes
    public List<MissaoModel> listarMissoes (){
        return missaoRepository.findAll();
    }

    //criar missoes
     public MissaoModel criarMissoes(MissaoModel missao){
        return missaoRepository.save(missao);
     }

     //editar missoes

    //deletar missoes
    public void deletarMissoes (Long id) {
        missaoRepository.deleteById(id);
    }
}
