package dev.aluno.java10x.CadastroDeNinjas.Missoes;


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
    public ResponseEntity<List<MissaoDTO>> listarMissao(){
       List <MissaoDTO> missaoLista = missaoService.listarMissoes();
       return ResponseEntity.ok(missaoLista);
    }

    //Post -- Manda Requisao para criar as missoes
    //Adicionar Missao(CREATE)
    @PostMapping("/criar")
    public ResponseEntity<?> criarMissoes (@RequestBody MissaoDTO missao){
        MissaoDTO missaoDTO = missaoService.criarMissoes(missao);
        return ResponseEntity.ok(missaoDTO);
    }

    //Put -- Manda Requisao para alterar as missoes
    //Alterar dados das missoes (UPTADE)
    @PutMapping("/alterar/{id}")
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
    public ResponseEntity<String> deletarMissao (@PathVariable Long id){
            missaoService.deletarMissoes(id);
            return ResponseEntity.ok("Missao deletada com sucesso!");
    }

}
