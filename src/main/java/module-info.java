module com.example.okp {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires jdk.jdi;

    opens com.example.okp to javafx.fxml;
    exports com.example.okp;
}