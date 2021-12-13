package projet.album.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import projet.album.model.Album;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

public class PhotosController extends ScrollPane implements Observateur, Controller {

    public Album album;
    public ArrayList<Image> list_photos = new ArrayList<Image>();
    public ArrayList<ImageView> list_view = new ArrayList<ImageView>();
    @FXML
    public Button open_dir;
    @FXML
    private GridPane images;

    public PhotosController() {

    }
    public void cree(Album album) {
        this.album = album;
    }
    @FXML
    public void clickAjouterPhoto() throws IOException {
        DirectoryChooser fenDossier = new DirectoryChooser();
        fenDossier.setTitle("Selectionner un répertoire de photos :");
        fenDossier.setInitialDirectory(new File(System.getProperty("user.home")));
        File dossier = fenDossier.showDialog(new Stage());

        if (dossier != null) {
            for (File fichier : dossier.listFiles()) {
                Image img = new Image(fichier.toURI().toString());
                String type = Files.probeContentType(fichier.toPath());
                list_photos.add(img);

                if (type != null && type.split("/")[0].equals("image")) {
                    ImageView view = new ImageView(img);
                    list_view.add(view);
                    int nb = images.getChildren().size();
                    view.setPreserveRatio(true);
                    view.setFitHeight(128);
                    view.setFitWidth(128);

                    int lig = nb / 3;
                    int col = nb % 3;
                    images.add(view, col, lig, 1, 1);

                    view.setOnMouseClicked(click -> {
                        TextInputDialog dialogText = new TextInputDialog("Titre d'image");
                        dialogText.setHeaderText("Donnez un titre");
                        dialogText.setContentText("Mettez un titre :");

                        dialogText.showAndWait().ifPresent(nom -> {
                            if (!nom.isEmpty()) {
                                album.ajouterPhoto(nom, fichier.toURI().toString());
                                album.size++;
                            }
                        });
                    });
                }
            }
        }
    }
    @Override
    public void reagir() {

    }
}
