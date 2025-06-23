package dev.aluno.java10x.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missao")
public class MissaoController {

    private MissaoService missaoService;

    public MissaoController(MissaoService missaoService) {
        this.missaoService = missaoService;
    }

    //Get -- Manda Requisao para mostrar as missoes
    @GetMapping("/listar")
    public List<MissaoDTO> listarMissao(){
        return missaoService.listarMissoes();
    }

    //Post -- Manda Requisao para criar as missoes
    //Adicionar Missao(CREATE)
    @PostMapping("/criar")
    public MissaoDTO criarMissoes (@RequestBody MissaoDTO missao){
        return missaoService.criarMissoes(missao);
    }

    //Put -- Manda Requisao para alterar as missoes
    //Alterar dados das missoes (UPTADE)
    @PutMapping("/alterar/{id}")
    public MissaoDTO alterarMissoes(@PathVariable Long id, @RequestBody MissaoDTO missaoAtualizada){
        return missaoService.alterarMissoes(id, missaoAtualizada);
    }

    //Delete -- Manda Requisao para Deletar as missoes
    //Deletar missao (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissao (@PathVariable Long id){
        missaoService.deletarMissoes(id);
    }

}
