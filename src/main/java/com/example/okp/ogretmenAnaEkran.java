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

public class ogretmenAnaEkran {

    @FXML
    private Button OgretmenDersEkleButton;


    @FXML
    private Button ogretmenCikisYapButton;

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
    private Label ogretmenHosgeldinLabel;

    private TreeItem<String> rootCategory;

    @FXML
    void initialize() {
        // Root kategori oluşturuluyor
        rootCategory = new TreeItem<>("Dersler");
        rootCategory.setExpanded(true); // Başlangıçta genişlemiş olsun
        ogretmenDersTreeView.setRoot(rootCategory); // TreeView'e root ekleniyor
    }


    @FXML
    private TreeView<String> ogretmenDersTreeView;



    @FXML
    private ListView<String> ogrenciListView;



    @FXML
    void ogretmenYeniKursEkle(ActionEvent event) {
        // Kategori, alt kategori ve ders adı alacak diyaloglar
        TextInputDialog kategoriDialog = new TextInputDialog();
        kategoriDialog.setTitle("Yeni Kategori Ekle");
        kategoriDialog.setHeaderText("Yeni kategori adını girin:");
        kategoriDialog.setContentText("Kategori:");

        kategoriDialog.showAndWait().ifPresent(kategori -> {
            TextInputDialog altKategoriDialog = new TextInputDialog();
            altKategoriDialog.setTitle("Yeni Alt Kategori Ekle");
            altKategoriDialog.setHeaderText("Yeni alt kategori adını girin:");
            altKategoriDialog.setContentText("Alt Kategori:");

            altKategoriDialog.showAndWait().ifPresent(altKategori -> {
                TextInputDialog dersDialog = new TextInputDialog();
                dersDialog.setTitle("Yeni Ders Ekle");
                dersDialog.setHeaderText("Yeni ders adını girin:");
                dersDialog.setContentText("Ders:");

                dersDialog.showAndWait().ifPresent(ders -> {
                    // Yeni kategori, alt kategori ve ders adı ekleniyor
                    TreeItem<String> kategoriItem = new TreeItem<>(kategori);
                    TreeItem<String> altKategoriItem = new TreeItem<>(altKategori);
                    TreeItem<String> dersItem = new TreeItem<>(ders);

                    // Alt kategori ve ders kategorisi altında sırasıyla hiyerarşi oluşturuluyor
                    kategoriItem.getChildren().add(altKategoriItem);
                    altKategoriItem.getChildren().add(dersItem);

                    // TreeView'e ekleniyor
                    rootCategory.getChildren().add(kategoriItem);
                });
            });
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
