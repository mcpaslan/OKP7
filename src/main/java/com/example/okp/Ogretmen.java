package com.example.okp;

import java.util.ArrayList;

public class Ogretmen extends Kullanici{

    public Ogretmen(String kullaniciAd, String sifre) {
        super(kullaniciAd, sifre);
    }
    ArrayList<String>dersler=new ArrayList<>();
    ArrayList<Ogrenci>ogrenciler=new ArrayList<>();

    public ArrayList<String> getDersler() {
        return dersler;
    }
}
