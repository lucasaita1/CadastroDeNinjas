package dev.aluno.java10x.CadastroDeNinjas.Missoes;
import dev.aluno.java10x.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissaoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;

    //OneToMany Uma Missao pode ter vários ninjas ou uma lista de ninjas
    @OneToMany(mappedBy = "missoes")
    private List <NinjaModel> ninjas;





}
