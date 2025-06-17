package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MissaoController {

    //Adicionar Ninja (CREATE)
    @PostMapping("/criarmissao")
    public String criarNinja(){
        return "Missao Criada";
    }

    //MOSTRAR Ninja por ID (READ)
    @GetMapping("/missoesID")
    public String mostrarNinjasPorId(){
        return "missoesID";
    }

    //VER TODOS NINJAS (READ)
    @GetMapping("/missoes")
    public String mostrarTodosNinjas(){
        return "Todas missoes";
    }

    //Alterar dados dos ninjas (UPTADE)
    @PutMapping("/modificarID")
    public String alterarDadosDoNinja(){
        return "Alterar missoes por ID";
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletarmissoesID")
    public String deletarNinjaPorId(){
        return "Deletar missoes por Id";
    }

}
