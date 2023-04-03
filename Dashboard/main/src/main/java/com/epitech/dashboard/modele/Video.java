package com.epitech.dashboard.modele;

import java.util.Objects;

public class Video {
    private String url;
    private String description;
    private String titre;


    public Video(String titre, String url, String description) {
        this.url = url;
        this.description = description;
        this.titre = titre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Video video = (Video) o;
        return titre.equals(video.titre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titre);
    }
}
