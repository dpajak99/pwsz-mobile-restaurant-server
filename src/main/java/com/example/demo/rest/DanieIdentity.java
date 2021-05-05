package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "danie", schema = "restauracja")
public class DanieIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_dania;

    @Column(name = "id_kategorii")
    private int id_kategorii;

    @Column(name = "nazwa")
    private String nazwa;

    @Column(name = "opis")
    private String opis;

    @Column(name = "cena")
    private int cena;

    public DanieIdentity() {
        super();
    }

    public DanieIdentity(int id_dania, int id_kategorii, String nazwa, String opis, int cena) {
        this.id_dania = id_dania;
        this.id_kategorii = id_kategorii;
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
    }

    public int getId_kategorii() {
        return id_kategorii;
    }

    public void setId_kategorii(int id_kategorii) {
        this.id_kategorii = id_kategorii;
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

    public int getCena() {
        return cena;
    }

    public int getId_dania() {
        return id_dania;
    }

    public void setId_dania(int id_dania) {
        this.id_dania = id_dania;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }
}
