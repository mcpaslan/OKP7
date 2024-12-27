package com.example.okp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ogretmenKayitOl {

    @FXML
    private ImageView gerigel1;

    @FXML
    private Button ogretmenKayitOlButton;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private TextField textfield;



    @FXML
    void ogretmenKayitOlButton(ActionEvent event) {
        String ogretmenKullaniciAdi = textfield.getText();
        String ogretmenSifre = passwordfield.getText();
        Ogretmen ogretmen1 = new Ogretmen(ogretmenKullaniciAdi, ogretmenSifre);
        ogretmenData.getInstance().addOgretmen(ogretmen1);

        if (textfield.getText().isEmpty() || passwordfield.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Kayıt");
            alert.setHeaderText("Kayıt Durumu");
            alert.setContentText("Lütfen tüm alanları doldurun!");
            alert.showAndWait();

        }

        else {
            try{
                hataKontrol kontrol=new hataKontrol();
                kontrol.kontrol(textfield.getText(), passwordfield.getText());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Kayıt");
                alert.setHeaderText("Kayıt Durumu");
                alert.setContentText("Kayıt olundu!");
                alert.showAndWait();
                textfield.setText("");
                passwordfield.setText("");
            }

            catch (AlfabetikException | NumerikException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Kayıt");
                alert.setHeaderText("Hata");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        }
    }
    @FXML
    void initialize(){
        gerigel1.setOnMouseClicked(event -> ongerigel1(event));
    }

    @FXML
    void ongerigel1(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ogretmenGiris.fxml"));
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


