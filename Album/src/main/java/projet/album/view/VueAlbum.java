package projet.album.view;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import projet.album.controller.Observateur;

public class VueAlbum extends GridPane implements Observateur {

    private Label num1, num2;

    public VueAlbum() {

    }

    @Override
    public void reagir() {

    }
}
