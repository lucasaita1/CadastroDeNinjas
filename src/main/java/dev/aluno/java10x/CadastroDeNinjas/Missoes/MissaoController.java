package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    //Get -- Manda Requisao para mostrar as missoes
    @GetMapping("/listar")
    public String listarMissao(){
        return "Missao listada com sucesso";
    }

    //Post -- Manda Requisao para criar as missoes
    //Adicionar Missao(CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Missao Criada";
    }

    //Put -- Manda Requisao para alterar as missoes
    //Alterar dados das missoes (UPTADE)
    @PutMapping("/alterar")
    public String alterarMissoes(){
        return "Alterar missoes";
    }

    //Delete -- Manda Requisao para Deletar as missoes
    //Deletar missao (DELETE)
    @DeleteMapping("/deletarmissoesID")
    public String deletarMissao(){
        return "Missao Deletada";
    }

}
