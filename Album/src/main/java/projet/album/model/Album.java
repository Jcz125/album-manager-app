package projet.album.model;

import javafx.application.Application;
import javafx.stage.Stage;

public class Album {

    private String name;
    private int size;
    private int currentPages;

    public Album (String name) {
        this.name = name;
        this.size = 0;
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
}
