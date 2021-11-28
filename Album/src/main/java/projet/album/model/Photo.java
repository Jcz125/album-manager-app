package projet.album.model;

import java.net.URL;

public class Photo {
    protected String title;
    protected String path;

    public Photo(String name, String path) {
        this.title = name;
        this.path = path;
    }

    public String getPath() {
        return this.path;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setPath(String newPath) {
        this.path = newPath;
    }
}
