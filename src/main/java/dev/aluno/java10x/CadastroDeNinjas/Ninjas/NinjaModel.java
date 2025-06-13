package dev.aluno.java10x.CadastroDeNinjas.Ninjas;
import dev.aluno.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Anotations Entity e Table transformam a classe em uma entidade e uma tabela no BD
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@ManyToOne Ninja só pode ter uma missao
    @ManyToOne
    @JoinColumn(name = "missoes_id") //Foreing key | Chave Estrangeira
    private MissaoModel missoes;

}
