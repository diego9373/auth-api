package com.io.auth.auth_api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;
    private String login;
    private String senha;

    public Usuario(String name, String login, String senha) {
        this.name = name;
        this.login = login;
        this.senha = senha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
