package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "pracownik", schema = "restauracja")
public class PracownikIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pracownika;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    public PracownikIdentity() {
        super();
    }

    public PracownikIdentity(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
}
