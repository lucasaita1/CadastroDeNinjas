package dev.aluno.java10x.CadastroDeNinjas.Missoes;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column(name = "nome_missoes")
    private String nome;
    @Column(name = "dificuldade")
    private String dificuldade;

    //OneToMany Uma Missao pode ter vários ninjas ou uma lista de ninjas
    @OneToMany(mappedBy = "missoes")
    @JsonIgnore
    private List <NinjaModel> ninjas;





}
