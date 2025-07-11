package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import dev.aluno.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissaoDTO {


    private Long id;
    private String nome;
    private String dificuldade;
    private List<NinjaModel> ninjas;
}
