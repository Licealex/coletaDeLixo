package br.com.fiap.coletaDeLixo.dto;

import br.com.fiap.coletaDeLixo.model.Cliente;

import java.util.Date;

public record ClienteExibicaoDTO(
        long clienteId,
        String nome,
        String cpf,
        Date data_nascimento,
        String email,
        String telefone,
        Date data_cadastro,
        String status_cliente,
        String tipo_cliente
) {
    public ClienteExibicaoDTO(Cliente cliente){
        this(
                cliente.getClienteId(),
                cliente.getNome(),
                cliente.getCPF(),
                cliente.getDataDeNascimento(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCadastro(),
                cliente.getStatusCliente(),
                cliente.getTipoCliente()
        );
    }
}
