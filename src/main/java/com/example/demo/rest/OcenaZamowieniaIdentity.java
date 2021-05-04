package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "ocena_zamowienia", schema = "restauracja")
public class OcenaZamowieniaIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_oceny_zamowienia;

    @Column(name = "skala")
    private int skala;

    @Column(name = "uwagi")
    private String uwagi;

    public OcenaZamowieniaIdentity() {
        super();
    }

    public OcenaZamowieniaIdentity(int skala, String uwagi) {
        this.skala = skala;
        this.uwagi = uwagi;
    }

    public int getSkala() {
        return skala;
    }

    public void setSkala(int skala) {
        this.skala = skala;
    }

    public String getUwagi() {
        return uwagi;
    }

    public void setUwagi(String uwagi) {
        this.uwagi = uwagi;
    }
}
