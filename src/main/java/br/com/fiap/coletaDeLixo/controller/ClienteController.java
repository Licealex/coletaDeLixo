package br.com.fiap.coletaDeLixo.controller;

import br.com.fiap.coletaDeLixo.dto.ClienteCadastroDTO;
import br.com.fiap.coletaDeLixo.dto.ClienteExibicaoDTO;
import br.com.fiap.coletaDeLixo.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @PostMapping("/cadastrodeclientes")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteExibicaoDTO salvar(
            @RequestBody
            ClienteCadastroDTO clienteCadastroDTO
    ){
        return clienteService.salvarCliente(clienteCadastroDTO);
    }
    @GetMapping("/clientes/{clientesId}")
    public ResponseEntity<ClienteExibicaoDTO> buscarClientePorID(
            @PathVariable
            Long clienteId
    ){
        return ResponseEntity.ok(clienteService.buscarClientePorId(clienteId));
    }
    @DeleteMapping("/clientes/{clientesId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(
            @PathVariable
            Long clienteId){
        clienteService.excluir(clienteId);
    }
    public ResponseEntity<ClienteExibicaoDTO> atualizar(
            @RequestBody
            ClienteCadastroDTO clienteCadastroDTO
    ){
        try{
            ClienteExibicaoDTO clienteExibicaoDTO = clienteService.atualizar(clienteCadastroDTO);
            return ResponseEntity.ok(clienteExibicaoDTO);
        } catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
}
