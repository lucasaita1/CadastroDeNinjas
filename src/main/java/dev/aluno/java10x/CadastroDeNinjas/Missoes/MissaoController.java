package dev.aluno.java10x.CadastroDeNinjas.Missoes;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private final MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //Get -- Manda Requisao para mostrar as missoes
    @GetMapping("/listar")
    @Operation(summary = "Lista as missões do BD", description = "Rota para o usuario ver e listar todas missoes do Banco de dados.")
    @ApiResponse(responseCode = "200", description = "OK")
    public ResponseEntity<List<MissaoDTO>> listarMissao(){
       List <MissaoDTO> missaoLista = missaoService.listarMissoes();
       return ResponseEntity.ok(missaoLista);
    }

    //Post -- Manda Requisao para criar as missoes
    //Adicionar Missao(CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria uma nova Missao", description = "Rota para o usuário criar uma missao.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "missao criada com sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na criacao da missao.")
    })
    public ResponseEntity<?> criarMissoes (@RequestBody MissaoDTO missao){
        MissaoDTO missaoDTO = missaoService.criarMissoes(missao);
        return ResponseEntity.ok(missaoDTO);
    }

    //Put -- Manda Requisao para alterar as missoes
    //Alterar dados das missoes (UPTADE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera missao por Id", description = "Usuario altera caracteristicas da missao do Id inserido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "missao alterada com sucesso!"),
            @ApiResponse(responseCode = "404", description = "missao nao foi encontrada ou nao existe no banco de dados!")
    })
    public ResponseEntity<?> alterarMissoes(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada){
        MissaoDTO missaoAlterada = missaoService.alterarMissoes(id, missaoAtualizada);
        if (missaoAlterada != null){
            return ResponseEntity.ok(missaoAlterada);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missao de ID: " + id + ", Nao foi encontrada ou nao existe!");
        }
    }

    //Delete -- Manda Requisao para Deletar as missoes
    //Deletar missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deleta missao do ID", description = "Deleta a missao do ID que o usuario inseriu")
    @ApiResponse(responseCode = "200", description = "Missao deletada com sucesso!")
    public ResponseEntity<String> deletarMissao (@PathVariable Long id){
            missaoService.deletarMissoes(id);
            return ResponseEntity.ok("Missao deletada com sucesso!");
    }

}
