package com.example.okp;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class ogrenciAnaEkran {

    @FXML
    private ImageView exit;

    @FXML
    private TreeView<?> ogrenciDersTreeView;

    @FXML
    private ListView<?> ogretmenListView;

    @FXML
    void ogretmenEkleButton(ActionEvent event) {

    }

    @FXML
    void ogrenciYeniKursEkle(ActionEvent event) {

    }

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
    private Button ogrenciCikisYapButton;

    @FXML
    private Button ogrenciDersEkle;

    @FXML
    private Label ogrenciHosgeldinLabel;

    @FXML
    private Button ogretmenEkleButon;

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
