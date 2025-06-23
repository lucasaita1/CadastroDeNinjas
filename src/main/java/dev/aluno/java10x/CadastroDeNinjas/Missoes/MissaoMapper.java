package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissaoMapper {
    public MissaoModel map(MissaoDTO missaoDTO){
        MissaoModel missaoModel = new MissaoModel();
        missaoModel.setId(missaoModel.getId());
        missaoModel.setNome(missaoModel.getNome());
        missaoModel.setDificuldade(missaoDTO.getDificuldade());
        missaoModel.setNinjas(missaoDTO.getNinjas());

        return missaoModel;
    }

    public MissaoDTO map(MissaoModel missaoModel){
        MissaoDTO missaoDTO = new MissaoDTO();
        missaoDTO.setId(missaoModel.getId());
        missaoDTO.setNome(missaoModel.getNome());
        missaoDTO.setDificuldade(missaoModel.getDificuldade());
        missaoDTO.setNinjas(missaoModel.getNinjas());

        return missaoDTO;
    }

}
