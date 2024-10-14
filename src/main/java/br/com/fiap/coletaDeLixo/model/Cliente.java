package br.com.fiap.coletaDeLixo.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_CLIENTE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Cliente implements UserDetails {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CLIENTE"
    )
    @SequenceGenerator(
            name = "SEQ_CLIENTE",
            sequenceName = "SEQ_CLIENTE",
            allocationSize = 1
    )
    @Column(name = "CLIENTE_ID")
    private Long clienteId;
    @Column(name = "NOME_CLIENTE")
    private String nome;
    @Column(name = "CPF")
    private String CPF;
    @Column(name = "DATA_DE_NASCIMENTO")
    private Date dataDeNascimento;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "CADASTRO")
    private Date cadastro;
    @Column(name = "STATUS_CLIENTE")
    private String statusCliente;
    @Column(name = "TIPO_CLIENTE")
    private String tipoCliente;
    @Enumerated(EnumType.STRING)
    private ClienteRole role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == ClienteRole.ADMIN){
            return List.of(
                    new SimpleGrantedAuthority("ROLE_ADMIN"),
                    new SimpleGrantedAuthority("ROLE_USER")
            );
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
