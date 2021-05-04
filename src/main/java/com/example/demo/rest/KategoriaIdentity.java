package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "kategoria", schema = "restauracja")
public class KategoriaIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_kategorii;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "opis")
    private String opis;

    public KategoriaIdentity() {
        super();
    }

    public KategoriaIdentity(String nazwa, String opis) {
        this.nazwa = nazwa;
        this.opis = opis;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }
}