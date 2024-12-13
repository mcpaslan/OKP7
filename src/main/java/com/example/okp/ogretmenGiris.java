package com.example.okp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ogretmenGiris {

    @FXML
    private ImageView geriGel;

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
    private TextField kullaniciAdTF;

    @FXML
    private Button ogretmenGirisYapButton;

    @FXML
    private PasswordField sifrePF;

    private ArrayList<Ogretmen> ogretmenler = new ArrayList<>();

    public ogretmenGiris(){
        ogretmenler.add(new Ogretmen("damla","123"));
        ogretmenler.add(new Ogretmen("seyda","456"));
        ogretmenler.add(new Ogretmen("merve","789"));

    }

    @FXML
    void ogretmenGirisYapButton(ActionEvent event) {
        String ogretmenKullaniciAdi = kullaniciAdTF.getText();
        String ogretmenSifre = sifrePF.getText();
        boolean giris = false;

        for (Ogretmen ogretmen : ogretmenler){

            if (ogretmen.getKullaniciAd().equals(ogretmenKullaniciAdi) && ogretmen.getSifre().equals(ogretmenSifre)){
                giris = true;
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
                FXMLLoader loader = new FXMLLoader(getClass().getResource("OgretmenAnaEkran.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ogretmenGirisYapButton.getScene().getWindow();
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
