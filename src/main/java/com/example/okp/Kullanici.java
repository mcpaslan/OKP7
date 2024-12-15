package com.example.okp;

public class Kullanici {
    private String kullaniciAd;
    private String sifre;

    public Kullanici(String kullaniciAd, String sifre) {
        this.kullaniciAd = kullaniciAd;
        this.sifre = sifre;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public String getSifre() {
        return sifre;
    }
}
