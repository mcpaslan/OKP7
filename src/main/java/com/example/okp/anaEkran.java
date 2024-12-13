package com.example.okp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class anaEkran {

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
