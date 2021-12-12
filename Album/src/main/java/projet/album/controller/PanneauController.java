package projet.album.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import projet.album.model.Album;
import projet.album.model.Photo;

public class PanneauController extends TilePane implements Observateur {
    public Album album;
    public Button b_prev, b_next, b_add, b_remove;
    public Label title, pages;

    public PanneauController(Album album) {
        this.album = album;
        this.title = new Label("Album : " + album.getName());
        this.pages = new Label("Pages : " + album.getCurrentPages() + "-"
                + (album.getCurrentPages()+1) + " sur " + album.getSize());
        this.b_prev = new Button("<-");
        this.b_next = new Button("->");
        this.b_add = new Button("+");
        this.b_remove = new Button("-");

        this.b_prev.setOnAction(event->album.previous());
        this.b_next.setOnAction(event-> album.next());
        this.b_add.setOnAction(event->album.ajouter());
        this.b_remove.setOnAction(event->album.retirer(album.getCurrentPages()));

        this.getChildren().addAll(b_prev, b_next, b_add, b_remove, title, pages);
        this.album.ajoutObservateur(this);
    }

    public void previous() {
        this.album.currentPages-=2;
        this.album.notifierObservateurs();
    }

    public void next() {
        this.album.currentPages+=2;
        this.album.notifierObservateurs();
    }

    public void ajouter() {
        String name = "Shinchan2";
        String path = "projet/album/蜡笔小新 yeah.jpg";
        this.album.photos.add(new Photo(name, path));
        this.album.size++;
        this.album.notifierObservateurs();
    }

    public void retirer() {
        this.album.photos.remove(0);
        this.album.size--;
        this.album.notifierObservateurs();
    }

    @Override
    public void reagir() {
        this.title.setText("Album : " + album.getName());
        this.pages.setText("Pages : " + album.getCurrentPages() + "-" + (album.getCurrentPages()+1)
                + " sur " + album.getSize());
    }
}
