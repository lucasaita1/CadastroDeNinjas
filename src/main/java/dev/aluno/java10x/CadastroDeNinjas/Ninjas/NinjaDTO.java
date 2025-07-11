package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import dev.aluno.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {


    private Long id;
    private String nome;
    private String email;
    private int idade;
    private String rank;
    private String imgUrl;
    private MissaoModel missoes;

}
