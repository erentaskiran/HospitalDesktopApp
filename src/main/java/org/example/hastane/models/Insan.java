package org.example.hastane.models;

import java.sql.Date;

public class Insan {
    public String tc;
    public String ad;
    public String soyad;
    public String cinsiyet;
    public long dogumTarihi;
    public String telefon;
    public String email;
    public String sifre;
    public long hesapAcilisTarihi;
    public long hesapGuncellemeTarihi;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public String getCinsiyet() {
        return cinsiyet;
    }

    public void setCinsiyet(String cinsiyet) {
        this.cinsiyet = cinsiyet;
    }

    public Date getDogumTarihi() {
        Date date = new Date(dogumTarihi);

        return date;
    }

    public void setDogumTarihi(Long dogumTarihi) {
        this.dogumTarihi = dogumTarihi;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public Date getHesapAcilisTarihi() {
        Date date = new Date(hesapAcilisTarihi);

        return date;
    }

    public void setHesapAcilisTarihi(long hesapAcilisTarihi) {
        this.hesapAcilisTarihi = hesapAcilisTarihi;
    }

    public Date getHesapGuncellemeTarihi() {
        Date date = new Date(hesapGuncellemeTarihi);

        return date;
    }

    public void setHesapGuncellemeTarihi(long hesapGuncellemeTarihi) {
        this.hesapGuncellemeTarihi = hesapGuncellemeTarihi;
    }
}
