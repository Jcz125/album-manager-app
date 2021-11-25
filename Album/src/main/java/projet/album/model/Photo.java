package projet.album.model;

import java.net.URL;

public class Photo {
    protected String title;
    protected URL path;

    public Photo(String name, URL path) {
        this.title = name;
        this.path = path;
    }

    public URL getPath() {
        return this.path;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setPath(URL newPath) {
        this.path = newPath;
    }
}
