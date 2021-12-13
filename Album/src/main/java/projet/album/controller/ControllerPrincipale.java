package projet.album.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextInputDialog;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projet.album.model.Album;

import java.io.*;
import java.util.ArrayList;

public class ControllerPrincipale implements Observateur, Controller {

    @FXML
    private Parent i_album;
    @FXML
    private Parent i_panneau;
    @FXML
    private Parent i_photos;

    @FXML
    private AlbumController i_albumController;
    @FXML
    private PanneauController i_panneauController;
    @FXML
    private PhotosController i_photosController;
    private Album album;

    public ArrayList<Controller> getControlleur() {
        ArrayList<Controller> ctrls = new ArrayList<Controller>();
        ctrls.add(i_albumController);
        ctrls.add(i_panneauController);
        ctrls.add(i_photosController);
        return ctrls;
    }

    @FXML
    public void clickNouveauAlbum() {
        album = new Album("Sans titre");
        this.cree(album);
        album.notifierObservateurs();
    }

    @FXML
    public void clickSaveAlbum() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Sauvegarder "+album.getName()+"");
        FileChooser.ExtensionFilter ef = new FileChooser.ExtensionFilter("Album (*.album)", "*.album");
        fc.getExtensionFilters().add(ef);
        File fichier = fc.showSaveDialog(new Stage());
        if (fichier != null) {
            try {
                FileOutputStream fstream = new FileOutputStream(fichier.getPath());
                ObjectOutputStream ostream = new ObjectOutputStream(fstream);
                ostream.writeObject(album);
                ostream.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void clickLoadAlbum() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Charger un album");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Album (*.album)", "*.album");
        fc.getExtensionFilters().add(extFilter);
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        File fichier = fc.showOpenDialog(new Stage());
        if (fichier != null) {
            try {
                FileInputStream fichierEntree = new FileInputStream(fichier.getPath());
                ObjectInputStream istream = new ObjectInputStream(fichierEntree);
                album = (Album)istream.readObject();
                album.alloueObs();
                this.cree(album);
                album.notifierObservateurs();
                istream.close();
                fichierEntree.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @FXML
    public void clickQuit() {
        Platform.exit();
    }

    @FXML
    public void clickRenommer() {
        TextInputDialog dialogText = new TextInputDialog("Nouveau titre d'Album");
        dialogText.setHeaderText("Donnez un titre");
        dialogText.setContentText("Mettez un titre :");

        dialogText.showAndWait().ifPresent(nom -> {
            if (!nom.isEmpty()) {
                album.renommerPhoto(0, nom);
            }
        });
    }

    @Override
    public void cree(Album alb) {
            this.album = alb;setAlbumPourControlleur();
    }

    public void setAlbumPourControlleur() {
        for (Controller c : this.getControlleur()) {
            c.cree(album);
        }
    }

    @Override
    public void reagir() {

    }
}
