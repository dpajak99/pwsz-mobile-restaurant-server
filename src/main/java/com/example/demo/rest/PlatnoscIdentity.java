package com.example.demo.rest;

import javax.persistence.*;
import java.util.TimeZone;

@Entity
@Table(name = "platnosc", schema = "restauracja")
public class PlatnoscIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_platnosci;

    @Column(name = "kwota_platnosci")
    private int kwota_platnosci;

    @Column(name = "metoda_platnosci")
    private String metoda_platnosci;

    @Column(name = "data_start")
    private TimeZone data_start;

    @Column(name = "data_oplacenia")
    private TimeZone data_oplacenia;

    public PlatnoscIdentity() {
        super();
    }

    public int getKwota_platnosci() {
        return kwota_platnosci;
    }

    public void setKwota_platnosci(int kwota_platnosci) {
        this.kwota_platnosci = kwota_platnosci;
    }

    public String getMetoda_platnosci() {
        return metoda_platnosci;
    }

    public void setMetoda_platnosci(String metoda_platnosci) {
        this.metoda_platnosci = metoda_platnosci;
    }

    public TimeZone getData_start() {
        return data_start;
    }

    public void setData_start(TimeZone data_start) {
        this.data_start = data_start;
    }

    public TimeZone getData_oplacenia() {
        return data_oplacenia;
    }

    public void setData_oplacenia(TimeZone data_oplacenia) {
        this.data_oplacenia = data_oplacenia;
    }
}
