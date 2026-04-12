module fr.quentin {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens fr.quentin.puissance4 to javafx.fxml;
    exports fr.quentin.puissance4;
}