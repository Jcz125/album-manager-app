package projet.album.view;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import projet.album.controller.Observateur;
import projet.album.model.Album;
import projet.album.model.Photo;

import java.net.URL;

public class VueAlbum extends GridPane implements Observateur {

    private Label num1, num2;
    private Photo photo1, photo2;

    public VueAlbum(Album album) {
        // import et affichage image
        URL image1URL = getClass().getResource("projet/album/shinchan_fond_boggle.jpg");
        URL image2URL = getClass().getResource("projet/album/蜡笔小新 yeah.jpg");
        Image image1 = new Image(image1URL.toExternalForm());
        Image image2 = new Image(image2URL.toExternalForm());
        ImageView image1View = new ImageView(image1);
        ImageView image2View = new ImageView(image2);
        // création photo
        Photo photo1 = new Photo("Shinchan1", getClass().getResource("projet/album/shinchan_fond_boggle.jpg"));
        Photo photo2 = new Photo("Shinchan2", getClass().getResource("projet/album/蜡笔小新 yeah.jpg"));
        // ajout photo

        album.getPhotos().add(photo1);
        album.getPhotos().add(photo2);

        Label num1 = new Label("" + album.findPhotoTitle(album.getCurrentPages()));
        Label num2 = new Label("" + album.findPhotoTitle(album.getCurrentPages()+1));
    }

    @Override
    public void reagir() {

    }
}
