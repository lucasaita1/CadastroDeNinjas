package dev.aluno.java10x.CadastroDeNinjas.Ninjas;
import dev.aluno.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;


//Anotations Entity e Table transformam a classe em uma entidade e uma tabela no BD
@Entity
@Table(name = "tb_cadastro")
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


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    @Override
    public String toString() {
        return "NinjaModel{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                '}';
    }
}
