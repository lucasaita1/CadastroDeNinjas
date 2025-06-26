package dev.aluno.java10x.CadastroDeNinjas.Missoes;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final MissaoMapper missaoMapper;

    public MissaoService(MissaoRepository missaoRepository, MissaoMapper missaoMapper) {
        this.missaoRepository = missaoRepository;
        this.missaoMapper = missaoMapper;
    }

    //listar missoes
    public List<MissaoDTO> listarMissoes() {
        List<MissaoModel> missoes = missaoRepository.findAll();
        return missoes.stream()
                .map(missaoMapper::map)
                .collect(Collectors.toList());

    }

    //criar missoes
    public MissaoDTO criarMissoes(MissaoDTO missao) {
        MissaoModel missaoModel = missaoMapper.map(missao);
        missaoRepository.save(missaoModel);
        return missaoMapper.map(missaoModel);

    }

    //editar missoes
    public MissaoDTO alterarMissoes(Long id, MissaoDTO missaoDTO) {
        Optional<MissaoModel> missaoExistente = missaoRepository.findById(id);
        if (missaoExistente.isPresent()) {
            MissaoModel missaoAtualizada = missaoMapper.map(missaoDTO);
            missaoAtualizada.setId(id);
            MissaoModel missaoSalva = missaoRepository.save(missaoAtualizada);
            return missaoMapper.map(missaoSalva);
        }
        return null;
    }

    //deletar missoes
  public void deletarMissoes(Long id){
        missaoRepository.deleteById(id);
  }
}

