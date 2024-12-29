package com.example.okp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class ogrenciAnaEkran {
    Ogrenci ogrenci_kullanici_adi = ogrenciData.getInstance().getOgrenciKullaniciAdi();
    String metin = "Hoşgeldiniz " + ogrenci_kullanici_adi.getKullaniciAd();

    private exit exitButtonController = new exit();


    @FXML
    private TreeView<String> ogrenciDersTreeView;

    @FXML
    private ListView<String> ogretmenListView;

    @FXML
    private Button ogrenciCikisYapButton;

    @FXML
    private Button ogrenciDersEkle;

    @FXML
    private Label ogrenciHosgeldinLabel;

    @FXML
    private Button ogretmenEkleButon;

    // Sınıf seviyesinde root kategori tanımı
    private TreeItem<String> rootCategory;

    @FXML
    void initialize() {
        // Root kategori oluşturuluyor
        rootCategory = new TreeItem<>("Dersler");
        rootCategory.setExpanded(true); // Başlangıçta genişlemiş olsun
        ogrenciDersTreeView.setRoot(rootCategory); // TreeView'e root ekleniyor
        ogrenciHosgeldinLabel.setText(metin);
        ArrayList<String> dersler = ogrenci_kullanici_adi.getDersler();
        for (String ders : dersler) {
            TreeItem<String> dersItem = new TreeItem<>(ders);
            rootCategory.getChildren().add(dersItem); // TreeItem olarak ekliyoruz
        }
        // Öğretmenler listesini ogretmenler listesine ekliyoruz
        ArrayList<String> ogretmenler = ogrenci_kullanici_adi.getOgretmenler();
        for (String ogretmen : ogretmenler) {
            ogretmenListView.getItems().add(ogretmen);
        }
    }



    @FXML
    void ogretmenYeniKursEkle(ActionEvent event) {
        // Öğretmen seçim diyalogu
        ChoiceDialog<String> ogretmenSecDialog = new ChoiceDialog<>();

        // Öğretmenlerin listesi ogretmenData'dan alınacak
        ArrayList<Ogretmen> ogretmenler = ogretmenData.getInstance().getOgretmenler();
        ArrayList<String> ogretmenIsimleri = new ArrayList<>();
        // Öğretmenlerin isimlerini listeye ekliyoruz
        for (Ogretmen ogretmen : ogretmenler) {
            ogretmenIsimleri.add(ogretmen.getKullaniciAd());
        }

        ogretmenSecDialog.getItems().addAll(ogretmenIsimleri);
        ogretmenSecDialog.setTitle("Öğretmen Seç");
        ogretmenSecDialog.setHeaderText("Bir öğretmen seçin:");
        ogretmenSecDialog.setContentText("Öğretmen:");

        // Öğretmen seçildikten sonra
        ogretmenSecDialog.showAndWait().ifPresent(selectedOgretmen -> {
            // Seçilen öğretmeni buluyoruz
            Ogretmen ogretmen = findOgretmenByAdi(selectedOgretmen);

            if (ogretmen != null) {
                // Ders seçimi diyalogu
                ChoiceDialog<String> dersSecDialog = new ChoiceDialog<>(null, ogretmen.getDersler());
                dersSecDialog.setTitle("Ders Seç");
                dersSecDialog.setHeaderText(selectedOgretmen + " öğretmeninin derslerini seçin:");
                dersSecDialog.setContentText("Ders:");

                dersSecDialog.showAndWait().ifPresent(selectedDers -> {
                    ogrenciDersTreeView.getRoot().getChildren().add(new TreeItem<>(selectedDers));
                    ogrenciData.getInstance().addOgretmenler(selectedOgretmen,ogrenci_kullanici_adi);
                    ogrenciData.getInstance().addDers(ogrenci_kullanici_adi,selectedDers);
                    ogretmen.ogrenciler.add(ogrenci_kullanici_adi);
                    ogretmenListView.getItems().add(selectedOgretmen);
                });
            }
        });
    }
    @FXML
    void exitButton(MouseEvent event) {
        exitButtonController.exitButton(null); // MouseEvent'i burada kullanmak gereksiz, null gönderebilirsiniz.
    }

    // Öğretmen ismine göre öğretmeni bulan yardımcı metot
    private Ogretmen findOgretmenByAdi(String ogretmenAdi) {
        for (Ogretmen ogretmen : ogretmenData.getInstance().getOgretmenler()) {
            if (ogretmen.getKullaniciAd().equals(ogretmenAdi)) {
                return ogretmen;
            }
        }
        return null;
    }





    @FXML
    void ogrenciCikisYapButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Çıkış Yap");
        alert.setHeaderText(null);
        alert.setContentText("Hesabınızdan çıkmak istediğinizden emin misiniz?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ogrenciGiris.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ogrenciCikisYapButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Online Kurs Platformu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
