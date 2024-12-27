package com.example.okp;

import java.util.ArrayList;

public class Ogrenci extends Kullanici {
    public Ogrenci(String kullaniciAd, String sifre) {
        super(kullaniciAd, sifre);
    }

    ArrayList<String> ogretmenler = new ArrayList<>();

    public ArrayList<String> getOgretmenler() {
        return ogretmenler;
    }
    @Override
    public void displayDetails() {
        System.out.println("Ogrenci Ad: " + getKullaniciAd());
        System.out.println("Sifre: "  + getSifre());
    }
}
