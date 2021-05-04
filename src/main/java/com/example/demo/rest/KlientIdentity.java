package com.example.demo.rest;

import javax.persistence.*;

@Entity
@Table(name = "klient", schema = "restauracja")
public class KlientIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_klienta;

    @Column(name = "id_adresu")
    private int id_adresu;

    @Column(name = "id_credencials")
    private int id_credencials;

    @Column(name = "imie")
    private String imie;

    @Column(name = "nazwisko")
    private String nazwisko;

    @Column(name = "telefon_komorkowy")
    private String telefon_komorkowy;

    @Column(name = "adres_email")
    private String adres_email;

    public KlientIdentity() {
        super();
    }

    public KlientIdentity(int id_adresu, int id_credencials, String imie, String nazwisko, String telefon_komorkowy, String adres_email) {
        this.id_adresu = id_adresu;
        this.id_credencials = id_credencials;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon_komorkowy = telefon_komorkowy;
        this.adres_email = adres_email;
    }

    public int getId_adresu() {
        return id_adresu;
    }

    public void setId_adresu(int id_adresu) {
        this.id_adresu = id_adresu;
    }

    public int getId_credencials() {
        return id_credencials;
    }

    public void setId_credencials(int id_credencials) {
        this.id_credencials = id_credencials;
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

    public String getTelefon_komorkowy() {
        return telefon_komorkowy;
    }

    public void setTelefon_komorkowy(String telefon_komorkowy) {
        this.telefon_komorkowy = telefon_komorkowy;
    }

    public String getAdres_email() {
        return adres_email;
    }

    public void setAdres_email(String adres_email) {
        this.adres_email = adres_email;
    }
}
