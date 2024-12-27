package com.example.okp;



import java.util.ArrayList;

public class ogretmenData {
    private static ogretmenData instance;
    private Ogretmen  aktifOgretmen;
    public static ogretmenData getInstance(){
        if(instance==null){
            instance=new ogretmenData();
        }
        return instance;
    }

    private ArrayList<Ogretmen> ogretmenler = new ArrayList<>();

    public ogretmenData(){
        Ogretmen damla = new Ogretmen("damla", "123");
        damla.getDersler().add("Veri Yapıları");

        Ogretmen seyda = new Ogretmen("seyda", "456");
        seyda.getDersler().add("Veri tabanı");

        Ogretmen merve = new Ogretmen("merve", "789");
        merve.getDersler().add("Java ile kodlama");

        ogretmenler.add(damla);
        ogretmenler.add(seyda);
        ogretmenler.add(merve);
    }

    public ArrayList<Ogretmen> getOgretmenler() {
        return ogretmenler;
    }

    public void addDersler(String ders,Ogretmen ogretmen) {
        ogretmen.dersler.add(ders);
    }


    public void addOgretmen(Ogretmen ogretmen){
        ogretmenler.add(ogretmen);
    }

    public void setOgretmenKullaniciAdi(Ogretmen aktifOgretmen) {
        this.aktifOgretmen = aktifOgretmen;
    }



    public Ogretmen getOgretmenKullaniciAdi() {
        return aktifOgretmen;
    }
}
