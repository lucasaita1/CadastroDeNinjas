package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import dev.aluno.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


//Anotations Entity e Table transformam a classe em uma entidade e uma tabela no BD
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "missoes" )
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "idade")
    private int idade;
    @Column(name = "rank")
    private String rank;

    //@ManyToOne Ninja só pode ter uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key | Chave Estrangeira
    private MissaoModel missoes;

}
