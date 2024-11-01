package org.example.hastane.models;

public class Hasta extends Insan{
    private String tc;
    private String ad;
    private String soyad;
    private String cinsiyet;
    private String dogumTarihi;
    private String telefon;
    private String email;
    private String sifre;
    private String hesapAcilisTarihi;
    private String hesapGuncellemeTarihi;

    public Hasta(String tc, String ad, String soyad, String cinsiyet, String dogumTarihi, String telefon, String email, String sifre, String hesapAcilisTarihi, String hesapGuncellemeTarihi) {
        this.tc = tc;
        this.ad = ad;
        this.soyad = soyad;
        this.cinsiyet = cinsiyet;
        this.dogumTarihi = dogumTarihi;
        this.telefon = telefon;
        this.email = email;
        this.sifre = sifre;
        this.hesapAcilisTarihi = hesapAcilisTarihi;
        this.hesapGuncellemeTarihi = hesapGuncellemeTarihi;
    }

}
