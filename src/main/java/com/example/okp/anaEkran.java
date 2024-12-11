package com.example.okp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class anaEkran {

    @FXML
    private Button ogrenciButton;

    @FXML
    private Button ogretmenButton;

    @FXML
    void onOgrenciGirisButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ogrenciGiris.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ogrenciButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Öğrenci Giriş Ekranı");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void onOgretmenGirisButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ogretmenGiris.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) ogretmenButton.getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Öğretmen Giriş Ekranı");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
