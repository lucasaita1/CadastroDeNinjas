package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import dev.aluno.java10x.CadastroDeNinjas.Missoes.MissaoModel;
import jakarta.persistence.*;

import java.util.List;

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
    private List <MissaoModel> missoes;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade, List<MissaoModel> missoes) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.missoes = missoes;
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

    public List<MissaoModel> getMissoes() {
        return missoes;
    }

    public void setMissoes(List<MissaoModel> missoes) {
        this.missoes = missoes;
    }

    @Override
    public String toString() {
        return "NinjaModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", idade=" + idade +
                ", missoes=" + missoes +
                '}';
    }
}
