package com.epitech.dashboard.facade;

import  com.epitech.dashboard.modele.Playlist;
import com.epitech.dashboard.modele.Profil;
import com.epitech.dashboard.modele.Video;

import java.util.List;

public interface FacadeVideosPlaylists {
    long creerPlaylist(String pseudo, String nomPlaylist) throws PlaylistPortantDejaMemeNomException;

    void depotVideo(String pseudo, Video video) throws VideoPortantDejaMemeNomException;

    void ajoutVideoPlaylist(String pseudo, String titreVideo, String nomPlaylist) throws VideoPortantDejaMemeNomException;

    List<Playlist> getPlaylisByUser(String pseudo) throws AucunePlaylistExistantException;

    List<Video> getVideosUser(String pseudo) throws AucuneVideoExistantException;

    List<Video> getAllVideos() throws AucuneVideoExistantException;

    Profil getProfil(String pseudo) throws UtilisateurInexistantException;


}
