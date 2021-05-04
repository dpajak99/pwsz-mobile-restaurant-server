package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "dane_zamowienia", schema = "restauracja")
public class DaneZamowieniaIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zamowienia;

    @Column(name = "id_dania")
    private int id_dania;

    @Column(name = "ilosc")
    private int ilosc;

    public DaneZamowieniaIdentity() {
        super();
    }

    public DaneZamowieniaIdentity(int id_dania, int ilosc) {
        this.id_dania = id_dania;
        this.ilosc = ilosc;
    }

    public int getId_zamowienia() {
        return id_zamowienia;
    }

    public void setId_zamowienia(int id_zamowienia) {
        this.id_zamowienia = id_zamowienia;
    }

    public int getId_dania() {
        return id_dania;
    }

    public void setId_dania(int id_dania) {
        this.id_dania = id_dania;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }
}