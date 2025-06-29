package dev.aluno.java10x.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Boas Vindas", description = "Rota para boas vindas ao usuário")
    public String boasVindas(){
     return ("Essa é a minha primeira mensagem e rota");
    }

    // ======== CRUD ========

    //Adicionar Ninja (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Criar um novo Ninja", description = "Rota para o usuário criar um ninja.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao do Ninja.")
    })
    public ResponseEntity <String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO ninjaDTO= ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso " + " ID:" + ninjaDTO.getId() + " nome : " + ninjaDTO.getNome() );
    }

    //VER TODOS NINJAS (READ)
    @GetMapping("/listar")
    @Operation(summary = "Lista os Ninjas do BD", description = "Rota para o usuario ver e listar todos ninjas do Banco de dados.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<NinjaDTO>> listarNinja (){
        List<NinjaDTO> listaNinja = ninjaService.listarNinja();
        return ResponseEntity.ok(listaNinja);
    }

    //MOSTRAR Ninja por ID (READ)
    //@PathVariable faz com que uma variavel retorne como caminho URL
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista um ninja por ID", description = "Usuario lista o ninja e caracteristicas pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK e retorna o Ninja"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado ou nao existe!")
    })
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
    @Operation(summary = "Altera ninja por Id", description = "Usuario altera caracteristicas do Ninja do Id inserido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja alterado com sucesso!"),
            @ApiResponse(responseCode = "422", description = "Ninja nao foi encontrado ou nao existe no banco de dados!")
    })
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
    @Operation(summary = "Deleta o ninja por ID", description = "Usuario deleta o ninja de ID escolhido.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja deletado com Sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja nao encontrado!")
    })
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
