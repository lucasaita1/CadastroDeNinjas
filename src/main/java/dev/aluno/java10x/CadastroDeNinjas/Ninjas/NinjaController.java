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

    // ======== CRUD ========

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    //VER TODOS NINJAS (READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinja (){
        return ninjaService.listarNinja();
    }

    //MOSTRAR Ninja por ID (READ)
    //@PathVariable faz com que uma variavel retorne como caminho URL
    @GetMapping("/listar/{id}")
    public NinjaModel listarNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    //Alterar dados dos ninjas (UPTADE)
    @PutMapping("/alterar/{id}")
    public String alterarDadosDoNinja(){
        return "Alterar ninja por ID";
    }

    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public String deletarNinjaPorId(){
        return "Deletar ninja por Id";
    }
}
