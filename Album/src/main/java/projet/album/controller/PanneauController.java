package projet.album.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projet.album.model.Album;
import projet.album.model.Photo;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class PanneauController extends TilePane implements Observateur, Controller {
    public Album album;
    @FXML
    public Button b_prev, b_next, b_add, b_remove;
    @FXML
    public Label title, pages;

    public void cree(Album album) {
        this.album = album;
        this.b_prev.setOnAction(event->album.previous());
        this.b_next.setOnAction(event-> album.next());
        this.b_add.setOnAction(event->album.ajouter());
        this.b_remove.setOnAction(event->album.retirer(album.getCurrentPages()));
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

    public void ajouter() { // à terminer
//        FileChooser fc = new FileChooser();
//        fc.setTitle("Charger une image");
//        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image PNG (*.png)", "*.png");
//        fc.getExtensionFilters().add(extFilter);
//        fc.setInitialDirectory(new File(System.getProperty("user.home")));
//        File fichier = fc.showOpenDialog(new Stage());
//        if (fichier != null) {
//            try {
//                FileInputStream fichierEntree = new FileInputStream(fichier.getPath());
//                ObjectInputStream istream = new ObjectInputStream(fichierEntree);
//                album = (Album)istream.readObject();
//                album.alloueObs();
//                this.cree(album);
//                album.notifierObservateurs();
//                istream.close();
//                fichierEntree.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
    }

    @Override
    public void reagir() {
        this.title.setText("Album : " + album.getName());
        this.pages.setText("Pages : " + (album.getCurrentPages()+1) + "-" + (album.getCurrentPages()+2)
                + " sur " + album.getSize());
    }
}
