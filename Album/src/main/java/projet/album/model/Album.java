package projet.album.model;

import javafx.application.Application;
import javafx.stage.Stage;
import projet.album.controller.Observateur;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

public class Album implements Serializable {

    public String name;
    public int size;
    public int currentPages;
    public ArrayList<Photo> photos;
    public transient ArrayList<Observateur> obs;

    public Album(String name) {
        this.name = name;
        this.size = 0;
        this.currentPages = 0;
        this.photos = new ArrayList<>();
        obs = new ArrayList<>();
    }

    public void alloueObs() {
        obs = new ArrayList<>();
    }

    public void ajouterPhoto(String nom, String chemin) {
        this.getPhotos().add(new Photo(nom, chemin));
        this.notifierObservateurs();
    }

    public void renommerPhoto(int i, String nom) {
        findPhoto(currentPages + i).setTitle(nom);
        this.notifierObservateurs();
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
        if (this.currentPages > 0)
            this.currentPages -= 2;
        this.notifierObservateurs();
    }

    public void next() {
        if (this.currentPages < this.photos.size() - 1)
            this.currentPages += 2;
        this.notifierObservateurs();
    }

    public void ajouter() {
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
        if (currentPages < this.photos.size()) {
            return this.photos.get(currentPages).title;
        }
        return null;
    }

    public String findPhotoPath(int currentPages) {
        if (currentPages < this.photos.size()) {
            return this.photos.get(currentPages).path;
        }
        return null;
    }

    public void ajoutObservateur(Observateur o) {
        this.obs.add(o);
    }

    public void notifierObservateurs() {
        for (Observateur o : this.obs) o.reagir();
    }
}
