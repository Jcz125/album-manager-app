package projet.album.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import projet.album.model.Album;
import projet.album.model.Photo;

public class AlbumController extends GridPane implements Observateur, Controller {

    @FXML
    public Label num1, num2;
    @FXML
    public Button b1, b2;
    @FXML
    public ImageView image1Vue, image2Vue;
    public Photo photo1, photo2;
    public Album album;

    public AlbumController() {

    }

    public void cree(Album album) {
        this.album = album;
        this.album.ajoutObservateur(this);
    }

    @FXML
    public void renommerPhoto1()
    {
        TextInputDialog dialogText = new TextInputDialog("Titre d'image");
        dialogText.setHeaderText("Donnez un titre");
        dialogText.setContentText("Mettez un titre :");

        dialogText.showAndWait().ifPresent(nom -> {
            if (!nom.isEmpty()) {
                album.renommerPhoto(0, nom);
            }
        });
    }

    @FXML
    public void renommerPhoto2()
    {
        TextInputDialog dialogText = new TextInputDialog("Titre d'image");
        dialogText.setHeaderText("Donnez un titre");
        dialogText.setContentText("Mettez un titre :");
        dialogText.showAndWait().ifPresent(nom -> {
            if (!nom.isEmpty()) {
                album.renommerPhoto(1, nom);
            }
        });
    }

    @Override
    public void reagir() {
        int current = this.album.getCurrentPages();
        this.photo1 = null;
        this.photo2 = null;

        if (album.findPhotoPath(current) != null) {
            this.photo1 = new Photo(album.findPhotoTitle(current), album.findPhotoPath(current));
        }

        if (album.findPhotoPath(current+1) != null) {
            this.photo2 = new Photo(album.findPhotoTitle(current+1), album.findPhotoPath(current+1));
        }

        if (photo1 != null) {
            this.image1Vue.setImage(new Image(photo1.getPath()));
            this.num1.setText("" + photo1.getTitle());
        } else {
            this.image1Vue.setImage(null);
            this.num1.setText("None");
        }

        if (photo2 != null) {
            this.image2Vue.setImage(new Image(photo2.getPath()));
            this.num2.setText("" + photo2.getTitle());
        } else {
            this.image2Vue.setImage(null);
            this.num2.setText("None");
        }
    }
}
