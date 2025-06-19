package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
     return ("Essa é a minha primeira mensagem e rota");
    }

    //VER TODOS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja (){
        return ninjaService.listarNinja();
    }

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }

    //MOSTRAR Ninja por ID (READ)
    //@PathVariable faz com que uma variavel retorne como caminho URL
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
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
