package com.example.okp;

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


public class ogretmenGiris {

    @FXML
    private ImageView gerigel5;


    private exit exitButtonController = new exit();

    @FXML
    private Button ogretmenKayitOlButton1;



    @FXML
    private TextField kullaniciAdTF;

    @FXML
    private Button ogretmenGirisYapButton;

    @FXML
    private PasswordField sifrePF;


    @FXML
    void ogretmenKayitOlButton1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ogretmenKayitOl.fxml"));
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
    void exitButton(MouseEvent event) {
        exitButtonController.exitButton(null); // MouseEvent'i burada kullanmak gereksiz, null gönderebilirsiniz.
    }
    @FXML
    void initialize(){
        gerigel5.setOnMouseClicked(event -> ongerigel5(event));
    }

    @FXML
    void ogretmenGirisYapButton(ActionEvent event) {
        String ogretmenKullaniciAdi = kullaniciAdTF.getText();
        String ogretmenSifre = sifrePF.getText();
        boolean giris = false;

        for (Ogretmen ogretmen : ogretmenData.getInstance().getOgretmenler()){

            if (ogretmen.getKullaniciAd().equals(ogretmenKullaniciAdi) && ogretmen.getSifre().equals(ogretmenSifre)){
                giris = true;
                Kullanici yeni_ogretmen=new Ogretmen(ogretmenKullaniciAdi,ogretmenSifre);
                yeni_ogretmen.displayDetails();
                ArrayList<Ogretmen> ogretmenler = ogretmenData.getInstance().getOgretmenler();
                ((Ogretmen) yeni_ogretmen).displayDetails(ogretmenler);
                ogretmenData.getInstance().setOgretmenKullaniciAdi(ogretmen);
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
    void ongerigel5(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("anaEkran.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Online Kurs Platformu");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}




