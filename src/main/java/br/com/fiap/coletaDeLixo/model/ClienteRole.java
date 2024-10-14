package br.com.fiap.coletaDeLixo.model;

import lombok.Getter;
@Getter
public enum ClienteRole {
    ADMIN("admin"),
    USER("user");
    private String role;
    ClienteRole(String role){
        this.role = role;
    }
}
