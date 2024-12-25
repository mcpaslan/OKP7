package com.example.okp;

import java.util.ArrayList;

public class ogrenciData {

    private static ogrenciData instance;
    private Ogrenci aktifOgrenci;

    public static ogrenciData getInstance() {
        if (instance == null) {
            instance = new ogrenciData();
        }
        return instance;
    }


    private ArrayList<Ogrenci> ogrenciler = new ArrayList<>();


    public ogrenciData() {
        ogrenciler.add(new Ogrenci("mucip", "123"));
        ogrenciler.add(new Ogrenci("mert", "456"));
        ogrenciler.add(new Ogrenci("muhammed", "789"));

    }

    public void addOgrenci(Ogrenci ogrenci) {
        ogrenciler.add(ogrenci);
    }

    public ArrayList<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void addOgretmenler(String ogretmen_adi,Ogrenci ogrenci) {
        ogrenci.ogretmenler.add(ogretmen_adi);
    }

    public void setOgrenciKullaniciAdi(Ogrenci aktifOgrenci) {
        this.aktifOgrenci = aktifOgrenci;
    }


    public Ogrenci getOgrenciKullaniciAdi() {
        return aktifOgrenci;
    }
}
