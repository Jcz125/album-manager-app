package projet.album.model;

import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Map;

public class Album {

    private String name;
    private int size;
    private int currentPages;
    private ArrayList<Photo> photos;

    public Album (String name) {
        this.name = name;
        this.size = 2;
        this.currentPages = 0;
        this.photos = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public int getCurrentPages() {
        return this.currentPages;
    }

    public ArrayList<Photo> getPhotos() {
        return this.photos;
    }

    public void previous() {
        this.currentPages-=2;
    }

    public void next() {
        this.currentPages+=2;
    }

    public void ajouter() {
        this.size++;
    }

    public void retirer() {
        this.size--;
    }

    public String findPhotoTitle(int currentPages) {
        return this.getPhotos().get(currentPages).title;
    }
}
