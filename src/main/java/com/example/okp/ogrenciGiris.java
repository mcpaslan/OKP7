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

public class ogrenciGiris {

    @FXML
    private ImageView geriGel;

    @FXML
    private Button girisYapButton;

    @FXML
    private TextField kullaniciAdTF;

    @FXML
    private PasswordField sifrePF;

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
    void onOgrenciGirisYapButton(ActionEvent event) {

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