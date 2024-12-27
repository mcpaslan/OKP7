package com.example.okp;

public abstract class Kullanici implements Ikullanici {
    private String kullaniciAd;
    private String sifre;

    public Kullanici(String kullaniciAd, String sifre) {
        this.kullaniciAd = kullaniciAd;
        this.sifre = sifre;
    }

    @Override
    public String getSifre() {
        return sifre;
    }

    @Override
    public String getKullaniciAd() {
        return kullaniciAd;
    }
    public abstract void displayDetails();
}
