package projet.album.view;

import javafx.scene.control.Button;
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
    private Button b1, b2;
    private Photo photo1, photo2;
    private Album album;
    private ImageView image1View, image2View;

    public VueAlbum(Album album) {
        this.album = album;
        this.album.ajoutObservateur(this);

        this.photo1 = album.findPhoto(album.getCurrentPages());
        this.photo2 = album.findPhoto(album.getCurrentPages()+1);

        this.num1 = new Label("" + photo1.getTitle());
        this.num2 = new Label("" + photo2.getTitle());

        Image image1 = new Image(photo1.getPath()); // "projet/album/shinchan_fond_boggle.jpg");
        Image image2 = new Image(photo2.getPath()); //"projet/album/蜡笔小新 yeah.jpg");

        image1View = new ImageView(image1);
        image2View = new ImageView(image2);
        image1View.setFitHeight(300);
        image1View.setFitWidth(300);
        image1View.preserveRatioProperty();
        image2View.setFitHeight(300);
        image2View.setFitWidth(300);
        image2View.preserveRatioProperty();

        this.b1 = new Button("Modifier");
        this.b2 = new Button("Modifier");

        String title1 = "New title 1";
        String title2 = "New title 2";

        this.b1.setOnAction(event->photo1.setTitle(title1));
        this.b2.setOnAction(event->photo2.setTitle(title2));

        this.add(num1, 0, 0);
        this.add(num2, 1, 0);
        this.add(b1, 0, 1);
        this.add(b2, 1, 1);
        this.add(image1View, 0, 2);
        this.add(image2View, 1, 2);

        this.album.ajoutObservateur(this);
    }

    @Override
    public void reagir() {
        int current = this.album.getCurrentPages();
        this.photo1 = new Photo(album.findPhotoTitle(current), album.findPhotoPath(current));
        this.photo2 = new Photo(album.findPhotoTitle(current+1), album.findPhotoPath(current+1));

        this.num1.setText("" + photo1.getTitle());
        this.num2.setText("" + photo2.getTitle());

        this.image1View.setImage(new Image(photo1.getPath()));
        this.image2View.setImage(new Image(photo2.getPath()));
    }


}
