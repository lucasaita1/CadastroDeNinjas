package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO= ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + " ID:" + ninjaDTO.getId() + " nome : " + ninjaDTO.getNome() );
    }

    //VER TODOS NINJAS (READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinja (){
        List<NinjaDTO> listaNinja = ninjaService.listarNinja();
        return ResponseEntity.ok(listaNinja);
    }

    //MOSTRAR Ninja por ID (READ)
    //@PathVariable faz com que uma variavel retorne como caminho URL
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarNinjasPorId(@PathVariable Long id){
        NinjaDTO ninjaId = ninjaService.listarNinjasPorId(id);
        if (ninjaId != null){
            return ResponseEntity.ok(ninjaId);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja de Id: " + id + ", NAO foi encontrado ou nao existe no banco de dados!");
        }
    }

    //Alterar dados dos ninjas (UPTADE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinja (@PathVariable Long id, @RequestBody NinjaDTO ninjaAtualizado) {
        if (ninjaService.listarNinjasPorId(id) != null) {
            NinjaDTO ninjaNovo = ninjaService.atualizarNinja(id, ninjaAtualizado);
            return ResponseEntity.ok("Ninja " + ninjaAtualizado.getNome() + " de Id: " + id + ". Atualizado com sucesso!" );

        }else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body("O ninja de Id: " + id + ", NAO foi encontrado ou nao existe no banco de dados!");
        }
    }


    //Deletar Ninjas (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja (@PathVariable Long id){
        if (ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaId(id);
            return ResponseEntity.ok("Ninja de ID:" + id + " Deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de ID:" + id + " Nao encontrado!");
        }

    }
}
