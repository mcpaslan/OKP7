package com.example.okp;

import java.util.ArrayList;
import java.util.List;

public class Ogretmen extends Kullanici{

    public Ogretmen(String kullaniciAd, String sifre) {
        super(kullaniciAd, sifre);
    }
    ArrayList<String>dersler=new ArrayList<>();
    ArrayList<Ogrenci>ogrenciler=new ArrayList<>();
    public ArrayList<String> getDersler() {
        return dersler;
    }
    @Override
    public void displayDetails() {
        System.out.println("Ogretmen Ad: " + getKullaniciAd());
        System.out.println("Sifre: " + getSifre());
    }
}
