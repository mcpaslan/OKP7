package com.example.okp;

import java.util.ArrayList;


public class Ogretmen extends Kullanici {

    public Ogretmen(String kullaniciAd, String sifre) {
        super(kullaniciAd, sifre);
    }

    ArrayList<String> dersler = new ArrayList<>();
    ArrayList<Ogrenci> ogrenciler = new ArrayList<>();
    ArrayList<Ogretmen> ogretmenler = new ArrayList<>();

    public ArrayList<String> getDersler() {
        return dersler;
    }

    @Override
    public void displayDetails() {
        System.out.println("Öğretmen Bilgileri:");
        System.out.println("Ogretmen Ad: " + getKullaniciAd());
        System.out.println("Sifre: " + getSifre());
        System.out.println("\n");
    }

    public void displayDetails(ArrayList<Ogretmen> ogretmenler) {
        System.out.println("Tüm Öğretmenler:");
        for (Ogretmen ogretmen : ogretmenler) {
            System.out.println(ogretmen.getKullaniciAd());
        }
    }
}
