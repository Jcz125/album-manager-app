package projet.album;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.AmbientLight;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import projet.album.controller.ControllerPrincipale;
import projet.album.model.Album;
import projet.album.model.Photo;

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
        ControllerPrincipale cp = fxmlLoader.getController();
        Album album = new Album("Shinchan");
        cp.cree(album);
        primaryStage.setTitle("Album");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
