package com.epitech.dashboard.modele;

import java.util.List;

public class Profil {
    private String pseudo;
    private List<Playlist> playlists;
    private List<Video> videos;

    public Profil(String pseudo, List<Playlist> playlists, List<Video> videos) {
        this.pseudo = pseudo;
        this.playlists = playlists;
        this.videos = videos;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Playlist> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<Playlist> playlists) {
        this.playlists = playlists;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}
