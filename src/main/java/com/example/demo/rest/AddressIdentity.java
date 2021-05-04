package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "adres", schema = "restauracja")
public class AddressIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_adresu;

    @Column(name = "ulica")
    private String ulica;

    @Column(name = "numer_mieszkania")
    private int numer_mieszkania;

    @Column(name = "miasto")
    private String miasto;

    @Column(name = "kod_pocztowy")
    private String kod_pocztowy;

    public AddressIdentity() {
        super();
    }

    public AddressIdentity(String ulica, int numer_mieszkania, String miasto, String kod_pocztowy) {
        this.ulica = ulica;
        this.numer_mieszkania = numer_mieszkania;
        this.miasto = miasto;
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNumer_mieszkania() {
        return numer_mieszkania;
    }

    public void setNumer_mieszkania(int numer_mieszkania) {
        this.numer_mieszkania = numer_mieszkania;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }
}
