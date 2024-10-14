package br.com.fiap.coletaDeLixo.service;

import br.com.fiap.coletaDeLixo.dto.RotaDeColetaCadastroDTO;
import br.com.fiap.coletaDeLixo.dto.RotaDeColetaExibicaoDTO;
import br.com.fiap.coletaDeLixo.model.RotaDeColeta;
import br.com.fiap.coletaDeLixo.repository.RotaDeColetaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RotaDeColetaService {
    @Autowired
    private RotaDeColetaRepository rotaDeColetaRepository;
    public RotaDeColetaExibicaoDTO salvarRota(RotaDeColetaCadastroDTO rotasDTO){
        RotaDeColeta rotas = new RotaDeColeta();
        BeanUtils.copyProperties(rotasDTO, rotas);

        RotaDeColeta rotasSalvo = rotaDeColetaRepository.save(rotas);
        return new RotaDeColetaExibicaoDTO(rotasSalvo);
    }
    public RotaDeColetaExibicaoDTO buscarRotaPorID(Long id){
        Optional<RotaDeColeta> rotaDeColetaOptional = rotaDeColetaRepository.findById(id);

        if (rotaDeColetaOptional.isPresent()){
            return new RotaDeColetaExibicaoDTO((rotaDeColetaOptional.get()));
        } else {
            throw new RuntimeException("Rota de Coleta não existe!");
        }
    }
    public List<RotaDeColetaExibicaoDTO> listarRotas(){
        return rotaDeColetaRepository
                .findAll()
                .stream()
                .map(RotaDeColetaExibicaoDTO::new)
                .toList();
    }
    /*
    public RotaDeColeta atualizar(RotaDeColeta rotaDeColeta){
        Optional<RotaDeColeta> rotaDeColetaOptional = rotaDeColetaRepository.findById(rotaDeColeta.getRotaID());

        if (rotaDeColetaOptional.isPresent()){
            return rotaDeColetaRepository.save(rotaDeColeta);
        } else {
            throw new RuntimeException("Rota de coleta não encontrada!");
        }
    }
   public void excluir(Long id){
        Optional<RotaDeColeta> rotaDeColetaOptional = rotaDeColetaRepository.findById(id);

        if (rotaDeColetaOptional.isPresent()){
            rotaDeColetaRepository.delete(rotaDeColetaOptional.get());
        } else {
            throw new RuntimeException("Rota de coleta não encontrada!");
        }
    }
     */
}
