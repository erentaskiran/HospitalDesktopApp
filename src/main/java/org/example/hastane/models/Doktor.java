package org.example.hastane.models;

public class Doktor extends Insan{
    public Doktor(String tc, String ad, String soyad, String cinsiyet, long dogumTarihi, String telefon, String email, String sifre, long hesapAcilisTarihi, long hesapGuncellemeTarihi) {
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
