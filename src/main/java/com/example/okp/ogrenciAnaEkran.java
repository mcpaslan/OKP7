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

public class ogrenciAnaEkran {

    @FXML
    private ImageView exit;

    @FXML
    private TreeView<String> ogrenciDersTreeView;

    @FXML
    private ListView<String> ogretmenListView;

    @FXML
    private Button ogrenciCikisYapButton;

    @FXML
    private Button ogrenciDersEkle;

    @FXML
    private Label ogrenciHosgeldinLabel;

    @FXML
    private Button ogretmenEkleButon;

    // Sınıf seviyesinde root kategori tanımı
    private TreeItem<String> rootCategory;

    @FXML
    void initialize() {
        // Root kategori oluşturuluyor
        rootCategory = new TreeItem<>("Dersler");
        rootCategory.setExpanded(true); // Başlangıçta genişlemiş olsun
        ogrenciDersTreeView.setRoot(rootCategory); // TreeView'e root ekleniyor
    }

    @FXML
    void ogrenciYeniKursEkle(ActionEvent event) {
        // Kategori al
        TextInputDialog kategoriDialog = new TextInputDialog();
        kategoriDialog.setTitle("Yeni Kategori Ekle");
        kategoriDialog.setHeaderText("Yeni kategori adını girin:");
        kategoriDialog.setContentText("Kategori:");

        kategoriDialog.showAndWait().ifPresent(kategori -> {
            if (kategori.isEmpty()) {
                showAlert("Hata", "Kategori adı boş olamaz.");
                return;
            }

            // Alt kategori al
            TextInputDialog altKategoriDialog = new TextInputDialog();
            altKategoriDialog.setTitle("Yeni Alt Kategori Ekle");
            altKategoriDialog.setHeaderText("Yeni alt kategori adını girin:");
            altKategoriDialog.setContentText("Alt Kategori:");

            altKategoriDialog.showAndWait().ifPresent(altKategori -> {
                if (altKategori.isEmpty()) {
                    showAlert("Hata", "Alt kategori adı boş olamaz.");
                    return;
                }

                // Ders adı al
                TextInputDialog dersDialog = new TextInputDialog();
                dersDialog.setTitle("Yeni Ders Ekle");
                dersDialog.setHeaderText("Yeni ders adını girin:");
                dersDialog.setContentText("Ders:");

                dersDialog.showAndWait().ifPresent(ders -> {
                    if (ders.isEmpty()) {
                        showAlert("Hata", "Ders adı boş olamaz.");
                        return;
                    }

                    // Yeni kategori, alt kategori ve ders adı ekleniyor
                    TreeItem<String> kategoriItem = findOrCreateTreeItem(rootCategory, kategori);
                    TreeItem<String> altKategoriItem = findOrCreateTreeItem(kategoriItem, altKategori);
                    TreeItem<String> dersItem = new TreeItem<>(ders);

                    // Alt kategoriye ders ekleniyor
                    altKategoriItem.getChildren().add(dersItem);
                });
            });
        });
    }

    @FXML
    void ogretmenEkleButton(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Yeni Öğretmen Ekle");
        dialog.setHeaderText("Lütfen yeni öğretmenin adını girin:");
        dialog.setContentText("Ad:");

        dialog.showAndWait().ifPresent(ogretmen -> {
            if (ogretmen.isEmpty()) {
                showAlert("Hata", "Öğretmen adı boş olamaz.");
                return;
            }
            ogretmenListView.getItems().add(ogretmen);
        });
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

    // Mevcut bir TreeItem'ı bul veya yenisini oluştur
    private TreeItem<String> findOrCreateTreeItem(TreeItem<String> parent, String value) {
        for (TreeItem<String> child : parent.getChildren()) {
            if (child.getValue().equals(value)) {
                return child;
            }
        }
        TreeItem<String> newItem = new TreeItem<>(value);
        parent.getChildren().add(newItem);
        return newItem;
    }

    // Hata mesajı gösteren metot
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
