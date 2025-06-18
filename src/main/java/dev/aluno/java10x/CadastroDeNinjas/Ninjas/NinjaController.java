package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
     return ("Essa é a minha primeira mensagem e rota");
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //MOSTRAR Ninja por ID (READ)
    @GetMapping("/todosID")
    public String mostrarNinjasPorId(){
        return "NinjaID";
    }

    //VER TODOS NINJAS (READ)
   @GetMapping("/todos")
    public String mostrarTodosNinjas(){
        return "Todos Ninjas";
    }

    //Alterar dados dos ninjas (UPTADE)
    @PutMapping("/alterarID")
    public String alterarDadosDoNinja(){
        return "Alterar ninja por ID";
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinjaPorId(){
        return "Deletar ninja por Id";
    }
}
