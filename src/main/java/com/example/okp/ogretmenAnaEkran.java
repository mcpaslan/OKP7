package com.example.okp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.io.IOException;
import java.util.ArrayList;


public class ogretmenAnaEkran {
    Ogretmen ogretmen_kullanici_adi = ogretmenData.getInstance().getOgretmenKullaniciAdi();
    String metin = "Hoşgeldiniz " + ogretmen_kullanici_adi.getKullaniciAd();


    @FXML
    private Button OgretmenDersEkleButton;

    @FXML
    private Button ogretmenCikisYapButton;

    private exit exitButtonController = new exit();


    @FXML
    private Label ogretmenHosgeldinLabel;

    @FXML
    private TreeView<String> ogretmenDersTreeView;


    @FXML
    private ListView<String> ogrenciListView;

    private TreeItem<String> rootCategory;

    @FXML
    void initialize() {
        // Root kategori oluşturuluyor
        rootCategory = new TreeItem<>("Dersler");
        rootCategory.setExpanded(true); // Başlangıçta genişlemiş olsun
        ogretmenDersTreeView.setRoot(rootCategory); // TreeView'e root ekleniyor
        ogretmenHosgeldinLabel.setText(metin);
        for(Ogrenci ogrenci:ogretmen_kullanici_adi.ogrenciler){
            ogrenciListView.getItems().add(ogrenci.getKullaniciAd());}
        ArrayList<String> dersler = ogretmen_kullanici_adi.getDersler();
        for (String ders : dersler) {
            TreeItem<String> dersItem = new TreeItem<>(ders);
            rootCategory.getChildren().add(dersItem); // TreeItem olarak ekliyoruz
        }
    }
    @FXML
    void exitButton(MouseEvent event) {
        exitButtonController.exitButton(null); // MouseEvent'i burada kullanmak gereksiz, null gönderebilirsiniz.
    }


    // Hata mesajı veya bilgi mesajı göstermek için showAlert metodunu tanımlama
    public void showAlert(String title, String message) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void ogretmenYeniKursEkle(ActionEvent event) {
        // Ders adı alacak diyalog
        TextInputDialog dersDialog = new TextInputDialog();
        dersDialog.setTitle("Yeni Ders Ekle");
        dersDialog.setHeaderText("Yeni ders adını girin:");
        dersDialog.setContentText("Ders:");

        dersDialog.showAndWait().ifPresent(ders -> {
            if (ders.isEmpty()) {
                // Ders adı boşsa hata mesajı göster
                showAlert("Hata", "Ders adı boş olamaz.");
                return;
            }

            ogretmenData.getInstance().addDersler(ders,ogretmen_kullanici_adi);
            // Yeni ders TreeItem olarak oluşturuluyor
            TreeItem<String> dersItem = new TreeItem<>(ders);

            // TreeView'e ekliyoruz (rootCategory ana kategori olarak tanımlanmış olmalı)
            rootCategory.getChildren().add(dersItem);


        });
    }



    @FXML
    void ogretmenCikisYapButton(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Çıkış Yap");
        alert.setHeaderText(null);
        alert.setContentText("Hesabınızdan çıkmak istediğinizden emin misiniz?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ogretmenGiris.fxml"));
                Parent root = loader.load();
                Stage stage = (Stage) ogretmenCikisYapButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Online Kurs Platformu");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
