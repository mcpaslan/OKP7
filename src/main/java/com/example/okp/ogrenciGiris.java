package com.example.okp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ogrenciGiris {
    @FXML
    private ImageView geriGel;

    @FXML
    private Button ogrenciGirisYapButton;


    @FXML
    private TextField kullaniciAdTF;

    @FXML
    private PasswordField sifrePF;
    @FXML
    private Button ogrenciKayitOlButton;

    @FXML
    private ImageView exit;


    @FXML
    void exitButton(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Çıkış Yap");
        alert.setHeaderText(null);
        alert.setContentText("Uygulamadan çıkmak istediğinizden emin misiniz?");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Platform.exit();
        }
    }
    @FXML
    void ogrenciKayitOlButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ogrenciKayitOl.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ogrenciGirisYapButton(ActionEvent event) {
        String ogrenciKullaniciAdi = kullaniciAdTF.getText();
        String ogrenciSifre = sifrePF.getText();
        boolean giris = false;

        for (Ogrenci ogrenci : ogrenciData.getInstance().getOgrenciler()){

            if (ogrenci.getKullaniciAd().equals(ogrenciKullaniciAdi) && ogrenci.getSifre().equals(ogrenciSifre)){
                giris = true;
                Kullanici yeni_ogrenci=new Ogrenci(ogrenciKullaniciAdi,ogrenciSifre);
                yeni_ogrenci.displayDetails();
                ogrenciData.getInstance().setOgrenciKullaniciAdi(ogrenci);
                break;
            }
        }
        if (giris == true){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Giriş Başarılı");
            alert.setHeaderText(null);
            alert.setContentText("Giriş başarılı!");
            alert.showAndWait();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ogrenciAnaEkran.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ogrenciGirisYapButton.getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.setTitle("Online Kurs Platformu");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Hatalı Giriş");
            alert.setHeaderText(null);
            alert.setContentText("Kullanıcı adı veya şifre hatalı!");
            alert.showAndWait();
        }
    }


    @FXML
    void oncekineGeriDon(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anaEkran.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) geriGel.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Online Kurs Platformu");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}