package projet.album;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import projet.album.view.VueAlbum;
import projet.album.view.VuePhotos;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("background.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        primaryStage.setTitle("Album");
        primaryStage.setScene(scene);

        BorderPane root = new BorderPane();
        root.setTop(new MenuBar());
        root.setBottom(new TilePane());
        root.setRight(new VuePhotos());
        root.setCenter(new VueAlbum());

        primaryStage.show();
    }
}
