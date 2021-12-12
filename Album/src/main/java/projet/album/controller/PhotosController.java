package projet.album.controller;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import projet.album.model.Album;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class PhotosController extends ScrollPane implements Observateur {

    public Album album;
    public ArrayList<Image> list_photos = new ArrayList<Image>();
    public ArrayList<ImageView> list_view = new ArrayList<ImageView>();
    public Button open_dir;

    public PhotosController(Album album) {
        this.album = album;
        this.open_dir = new Button("Ouvrir répertoire");
        if (list_view.size() != 0) {
            for (ImageView i : list_view) {
                this.getChildren().add(i);
            }
        }
    }

    public void load_r() throws IOException {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Selectionner un répertoire de photos :");
        dc.setInitialDirectory(new File(System.getProperty("user.home")));
        File d = dc.showDialog(new Stage());

        if (d != null) {
                for (File file : d.listFiles()) {
                    Image img = new Image(file.toURI().toString());
                    String type = Files.probeContentType(file.toPath());
                    list_photos.add(img);

                    if (type != null && type.split("/")[0].equals("image")) {
                        ImageView view = new ImageView(img);
                        list_view.add(view);
                    }
                }
        }
    }
    @Override
    public void reagir() {

    }
}
