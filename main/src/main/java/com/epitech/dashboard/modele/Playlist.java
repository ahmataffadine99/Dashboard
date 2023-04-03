package com.epitech.dashboard.modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Playlist {
    private static long ID = 0;
    private long id;
    private String nomPlaylist;
    private List<Video> videos;


    public Playlist() {
        this.videos = new ArrayList<>();
    }

    public Playlist(String nomPlaylist) {
        this.id = ++ID;
        this.nomPlaylist = nomPlaylist;
        this.videos = new ArrayList<>();

    }

    public static long getID() {
        return ID;
    }

    public long getId() {
        return id;
    }

    public String getNomPlaylist() {
        return nomPlaylist;
    }

    public Collection<Video> getVideos() {
        return videos;
    }

    public void setNomPlaylist(String nomPlaylist) {
        this.nomPlaylist = nomPlaylist;
    }
}
