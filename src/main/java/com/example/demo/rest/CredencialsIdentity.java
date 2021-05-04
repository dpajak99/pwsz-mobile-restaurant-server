package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "credencials", schema = "restauracja")
public class CredencialsIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_credencials;

    @Column(name = "token")
    private int token;

    @Column(name = "password")
    private String password;

    public CredencialsIdentity() {
        super();
    }

    public CredencialsIdentity(int token, String password) {
        this.token = token;
        this.password = password;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
