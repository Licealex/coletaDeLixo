package br.com.fiap.coletaDeLixo.service;

import br.com.fiap.coletaDeLixo.Exception.UsuarioNaoEncontradoException;
import br.com.fiap.coletaDeLixo.dto.ClienteCadastroDTO;
import br.com.fiap.coletaDeLixo.dto.ClienteExibicaoDTO;
import br.com.fiap.coletaDeLixo.model.Cliente;
import br.com.fiap.coletaDeLixo.repository.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteExibicaoDTO salvarCliente(ClienteCadastroDTO clienteDTO){

        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteDTO, cliente);

        Cliente clienteSalvo = clienteRepository.save(cliente);
        return new ClienteExibicaoDTO(clienteSalvo);
    }

    public ClienteExibicaoDTO buscarClientePorId(Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()){
            return new ClienteExibicaoDTO(clienteOptional.get());
        } else {
            throw new UsuarioNaoEncontradoException("Cliente não existe!");
        }
    }
    public void excluir(Long id){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (clienteOptional.isPresent()){
            clienteRepository.delete(clienteOptional.get());
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }
    public ClienteExibicaoDTO atualizar(ClienteCadastroDTO clienteDTO){
        Optional<Cliente> clienteOptional = clienteRepository.findById(clienteDTO.clienteId());

        if (clienteOptional.isPresent()){
            Cliente cliente = new Cliente();
            BeanUtils.copyProperties(clienteDTO, cliente);
            return new ClienteExibicaoDTO(clienteRepository.save(cliente));
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

}
