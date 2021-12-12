package projet.album.model;

import javafx.application.Application;
import javafx.stage.Stage;
import projet.album.controller.Observateur;

import java.util.ArrayList;
import java.util.Map;

public class Album {

    public String name;
    public int size;
    public int currentPages;
    public ArrayList<Photo> photos;
    public ArrayList<Observateur> obs = new ArrayList<>();

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

    public void setCurrentPages(int n) {
        this.currentPages = n;
    }

    public ArrayList<Photo> getPhotos() {
        return this.photos;
    }

    public void previous() {
        this.currentPages-=2;
        this.notifierObservateurs();
    }

    public void next() {
        this.currentPages+=2;
        this.notifierObservateurs();
    }

    public void ajouter() {
        String name = "Shinchan2";
        String path = "projet/album/蜡笔小新 yeah.jpg";
        this.photos.add(new Photo(name, path));
        this.size++;
        this.notifierObservateurs();
    }

    public void retirer(int i) {
        this.photos.remove(i);
        this.size--;
        this.notifierObservateurs();
    }

    public Photo findPhoto(int index) {
        return this.photos.get(index);
    }

    public String findPhotoTitle(int currentPages) {
        return this.photos.get(currentPages).title;
    }

    public String findPhotoPath(int currentPages) {
        return this.photos.get(currentPages).path;
    }

    public void ajoutObservateur(Observateur o) {
        this.obs.add(o);
    }

    public void notifierObservateurs() {
        for (Observateur o : this.obs) o.reagir();
    }
}
