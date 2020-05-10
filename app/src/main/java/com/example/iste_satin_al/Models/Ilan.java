package com.example.iste_satin_al.Models;

public class Ilan {
    int id;
    String baslik;
    String sehir;
    String sektor;
    String tur;
    String tarih;
    String username;

    public Ilan(int id, String baslik, String sehir, String sektor, String tur, String tarih, String username) {
        this.id = id;
        this.baslik = baslik;
        this.sehir = sehir;
        this.sektor = sektor;
        this.tur = tur;
        this.tarih = tarih;
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getSehir() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }

    public String getSektor() {
        return sektor;
    }

    public void setSektor(String sektor) {
        this.sektor = sektor;
    }

    public String getTur() {
        return tur;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
