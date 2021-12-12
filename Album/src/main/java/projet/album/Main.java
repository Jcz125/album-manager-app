package projet.album;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projet.album.model.Album;
import projet.album.model.Photo;
import projet.album.view.PanneauControle;
import projet.album.view.VueAlbum;
import projet.album.view.VuePhotos;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InterfaceMain.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1400, 800);
            primaryStage.setTitle("Album");

        BorderPane root = new BorderPane();
//        Scene scene = new Scene(root, 1400, 800);
            primaryStage.setScene(scene);

        Album album = new Album("Shinchan");
        album.getPhotos().add(new Photo("Shinchan1", "projet/album/shinchan_fond_boggle.jpg"));
        album.getPhotos().add(new Photo("Shinchan1", "projet/album/shinchan_fond_boggle.jpg"));

        root.setTop(new MenuBar());
        root.setBottom(new PanneauControle(album));
        root.setRight(new VuePhotos());
        root.setCenter(new VueAlbum(album));

            primaryStage.show();
    }
}
