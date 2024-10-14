package br.com.fiap.coletaDeLixo.dto;

import br.com.fiap.coletaDeLixo.model.Cliente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

public record ClienteCadastroDTO(
        long clienteId,
        String senha,
        @NotBlank(message = "O nome do cliente é obrigatório!")
        String nome,
        @NotBlank(message = "O cpf do cliente é obrigatório!")
        String cpf,
        @NotBlank(message = "A data de nascimento do cliente é obrigatório!")
        Date data_nascimento,
        @NotBlank(message = "O email do cliente é obrigatório!")
        @Email(message = "O e-mail do usuário não é válido!")
        String email,
        @NotBlank(message = "O telefone do cliente é obrigatório!")
        String telefone,
        @NotBlank(message = "A data de nascimento do cliente é obrigatório!")
        Date data_cadastro,
        @NotBlank(message = "O status do cliente é obrigatório!")
        String status_cliente,
        @NotBlank(message = "O tipo do cliente é obrigatório!")
        String tipo_cliente
) {
}
