package org.example.hastane.models;

public class Hasta extends Insan{
    public Hasta(String tc, String ad, String soyad, String cinsiyet, Long dogumTarihi, String telefon, String email, String sifre, long hesapAcilisTarihi, long hesapGuncellemeTarihi) {
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
