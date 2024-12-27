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
        // Sample students with courses
        Ogrenci ogrenci1 = new Ogrenci("mucip", "123");

        Ogrenci ogrenci2 = new Ogrenci("mert", "456");

        Ogrenci ogrenci3 = new Ogrenci("muhammed", "789");

        ogrenciler.add(ogrenci1);
        ogrenciler.add(ogrenci2);
        ogrenciler.add(ogrenci3);
    }

    public void addOgrenci(Ogrenci ogrenci) {
        ogrenciler.add(ogrenci);
    }

    public ArrayList<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void addOgretmenler(String ogretmen_adi, Ogrenci ogrenci) {
        ogrenci.ogretmenler.add(ogretmen_adi);
    }

    public void setOgrenciKullaniciAdi(Ogrenci aktifOgrenci) {
        this.aktifOgrenci = aktifOgrenci;
    }

    public Ogrenci getOgrenciKullaniciAdi() {
        return aktifOgrenci;
    }

    // Add a course to a student's list of courses
    public void addDers(Ogrenci ogrenci, String ders) {
        ogrenci.getDersler().add(ders);
    }



    // Get all courses for a specific student
    public ArrayList<String> getDersler(Ogrenci ogrenci) {
        return ogrenci.getDersler();
    }


}
