package projet.album.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import projet.album.controller.Observateur;
import projet.album.model.Album;

public class PanneauControle extends TilePane implements Observateur {

    private Album album;
    private Button b_prev, b_next, b_add, b_remove;
    private Label title, pages;

    public PanneauControle(Album album) {
        this.album = album;
        this.title = new Label("Album : " + album.getName());
        this.pages = new Label("Pages : " + album.getCurrentPages() + "-"
                + album.getCurrentPages()+1 + " sur " + album.getSize());
        this.b_prev = new Button("<-");
        this.b_next = new Button("->");
        this.b_add = new Button("+");
        this.b_remove = new Button("-");

        this.b_prev.setOnAction(event->album.previous());
        this.b_next.setOnAction(event-> album.next());
        this.b_add.setOnAction(event->album.ajouter());
        this.b_remove.setOnAction(event->album.retirer(album.getCurrentPages()));

        this.getChildren().addAll(b_prev, b_next, b_add, b_remove);
        this.album.ajoutObservateur(this);
    }

    @Override
    public void reagir() {
        this.title.setText("Album : " + album.getName());
        this.pages.setText("Pages : " + album.getCurrentPages() + "-" + album.getCurrentPages()+1
                + " sur " + album.getSize());
    }
}
