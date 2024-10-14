package br.com.fiap.coletaDeLixo.controller;

import br.com.fiap.coletaDeLixo.dto.RotaDeColetaCadastroDTO;
import br.com.fiap.coletaDeLixo.dto.RotaDeColetaExibicaoDTO;
import br.com.fiap.coletaDeLixo.model.RotaDeColeta;
import br.com.fiap.coletaDeLixo.service.RotaDeColetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RotaDeColetaController {
    @Autowired
    private RotaDeColetaService rotaDeColetaService;
    @PostMapping("/rotas")
    @ResponseStatus(HttpStatus.CREATED)
    public RotaDeColetaExibicaoDTO salvarRota(@RequestBody RotaDeColetaCadastroDTO rotas){
        return rotaDeColetaService.salvarRota(rotas);
    }
    @GetMapping("/rotas/{rotasID}")
    public ResponseEntity<RotaDeColetaExibicaoDTO> buscarRotaPorID(@PathVariable Long rotasID){
        try {
            return ResponseEntity.ok(rotaDeColetaService.buscarRotaPorID(rotasID));
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/rotas")
    @ResponseStatus(HttpStatus.OK)
    public List<RotaDeColetaExibicaoDTO> listarRotas(){
        return rotaDeColetaService.listarRotas();
    }
    /*
    @PutMapping("/rotas")
    @ResponseStatus(HttpStatus.OK)
    public RotaDeColeta atualizar(@RequestBody RotaDeColeta rotasDeColeta){
        return rotaDeColetaService.atualizar(rotasDeColeta);
    }
    @DeleteMapping("/rotas/{rotasID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long rotaID){
        rotaDeColetaService.excluir(rotaID);
    }
     */
}
