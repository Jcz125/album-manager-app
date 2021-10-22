module projet.album {
    requires javafx.controls;
    requires javafx.fxml;


    opens projet.album to javafx.fxml;
    exports projet.album;
}