package com.example.okp;

import java.util.ArrayList;

public class Ogrenci extends Kullanici {
    public Ogrenci(String kullaniciAd, String sifre) {
        super(kullaniciAd, sifre);
    }

    ArrayList<String> ogretmenler = new ArrayList<>();
    ArrayList<String> dersler = new ArrayList<>();
    public ArrayList<String> getOgretmenler() {
        return ogretmenler;
    }
    @Override
    public void displayDetails() {
        System.out.println("Öğrenci Bilgileri:");
        System.out.println("Öğrenci Ad: " + getKullaniciAd());
        System.out.println("Sifre: " + getSifre());
        System.out.println("\n");
    }

    public ArrayList<String> getDersler() {
        return dersler;
    }

    public void displayDetails(ArrayList<Ogrenci> ogrenciler) {
        System.out.println("Tüm Öğrenciler:");
        for (Ogrenci ogrenci : ogrenciler) {
            System.out.println(ogrenci.getKullaniciAd());
        }
    }
}
