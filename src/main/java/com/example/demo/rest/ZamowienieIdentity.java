package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "zamowienie", schema = "restauracja")
public class ZamowienieIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_zamowienia;

    @Column(name = "id_pracownika")
    private int id_pracownika;

    @Column(name = "id_klienta")
    private int id_klienta;

    @Column(name = "id_oceny_zamowienia")
    private int id_oceny_zamowienia;

    @Column(name = "id_platnosci")
    private int id_platnosci;

    @Column(name = "realizacja_status")
    private String realizacja_status;

    @Column(name = "uwagi_dod")
    private String uwagi_dod;

    public ZamowienieIdentity() {
        super();
    }

    public ZamowienieIdentity(int id_pracownika, int id_klienta, int id_oceny_zamowienia, int id_platnosci, String realizacja_status, String uwagi_dod) {
        this.id_pracownika = id_pracownika;
        this.id_klienta = id_klienta;
        this.id_oceny_zamowienia = id_oceny_zamowienia;
        this.id_platnosci = id_platnosci;
        this.realizacja_status = realizacja_status;
        this.uwagi_dod = uwagi_dod;
    }

    public int getId_pracownika() {
        return id_pracownika;
    }

    public void setId_pracownika(int id_pracownika) {
        this.id_pracownika = id_pracownika;
    }

    public int getId_klienta() {
        return id_klienta;
    }

    public void setId_klienta(int id_klienta) {
        this.id_klienta = id_klienta;
    }

    public int getId_oceny_zamowienia() {
        return id_oceny_zamowienia;
    }

    public void setId_oceny_zamowienia(int id_oceny_zamowienia) {
        this.id_oceny_zamowienia = id_oceny_zamowienia;
    }

    public int getId_platnosci() {
        return id_platnosci;
    }

    public void setId_platnosci(int id_platnosci) {
        this.id_platnosci = id_platnosci;
    }

    public String getRealizacja_status() {
        return realizacja_status;
    }

    public void setRealizacja_status(String realizacja_status) {
        this.realizacja_status = realizacja_status;
    }

    public String getUwagi_dod() {
        return uwagi_dod;
    }

    public void setUwagi_dod(String uwagi_dod) {
        this.uwagi_dod = uwagi_dod;
    }
}
