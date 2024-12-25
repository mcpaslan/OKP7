package com.example.okp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.scene.Node;

public class ogrenciKayitOl {

    @FXML
    private ImageView gerigel;

    @FXML
    private Button ogrenciKayitOlButton;

    @FXML
    private PasswordField passwordfield1;

    @FXML
    private TextField textfield1;

    @FXML
    void initialize(){
        gerigel.setOnMouseClicked(event -> ongerigel(event));
    }

    @FXML
    void ongerigel(MouseEvent event) {

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ogrenciGiris.fxml"));
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



    @FXML
    void ogrenciKayitOlButton(ActionEvent event) {
        String ogrenciKullaniciAdi = textfield1.getText();
        String ogrenciSifre = passwordfield1.getText();
        Ogrenci talebe = new Ogrenci(ogrenciKullaniciAdi, ogrenciSifre);
        ogrenciData.getInstance().addOgrenci(talebe);

        if (textfield1.getText().isEmpty() && passwordfield1.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kayıt");
            alert.setHeaderText("Kayıt Durumu");
            alert.setContentText("Lütfen tüm alanları doldurun!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kayıt");
            alert.setHeaderText("Kayıt Durumu");
            alert.setContentText("Kayıt olundu!");
            alert.showAndWait();
            textfield1.setText("");
            passwordfield1.setText("");
        }

    }
}




