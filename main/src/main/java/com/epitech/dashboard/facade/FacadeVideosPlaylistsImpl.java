package com.epitech.dashboard.facade;

import  com.epitech.dashboard.modele.Playlist;
import com.epitech.dashboard.modele.Profil;
import com.epitech.dashboard.modele.Video;

import org.springframework.stereotype.Component;

import java.util.*;

@Component("facadeVideosPlaylistsImpl")
public class FacadeVideosPlaylistsImpl implements FacadeVideosPlaylists {
    private Map<String, Map<String, Playlist>> userPlaylist;
    private Map<String, Map<String, Video>> userVideos;

    public FacadeVideosPlaylistsImpl() {
        this.userPlaylist = new HashMap<>();
        this.userVideos = new HashMap<>();
    }


    @Override
    public long creerPlaylist(String pseudo, String nomPlaylist) throws PlaylistPortantDejaMemeNomException {
        Map<String, Playlist> playlistMap = userPlaylist.get(pseudo);
        if (Objects.isNull(playlistMap)) {
            playlistMap = new HashMap<>();
            Playlist p = new Playlist(nomPlaylist);
            playlistMap.put(nomPlaylist, p);
            userPlaylist.put(pseudo, playlistMap);
            return p.getId();
        } else if (userPlaylist.get(pseudo).containsKey(nomPlaylist))
            throw new PlaylistPortantDejaMemeNomException();

        else {
            Playlist p = new Playlist(nomPlaylist);
            userPlaylist.get(pseudo).put(nomPlaylist, p);
            return p.getId();
        }


    }

    @Override
    public void depotVideo(String pseudo, Video video)
            throws VideoPortantDejaMemeNomException {
        Map<String, Video> videoMap = userVideos.get(pseudo);
        if (Objects.isNull(videoMap)) {
            videoMap = new HashMap<>();
            videoMap.put(video.getTitre(), video);
            userVideos.put(pseudo, videoMap);

        } else if (userVideos.get(pseudo).containsKey(video.getTitre()))
            throw new VideoPortantDejaMemeNomException();
        else userVideos.get(pseudo).put(video.getTitre(), video);
    }

    @Override
    public void ajoutVideoPlaylist(String pseudo,
                                   String titreVideo, String nomPlaylist)
            throws VideoPortantDejaMemeNomException {
        Optional<Video> v = userPlaylist.get(pseudo).get(nomPlaylist).getVideos().stream().filter(video ->
                video.getTitre().equals(titreVideo)).findFirst();
        if (v.isPresent()) {
            throw new VideoPortantDejaMemeNomException();
        }
        userPlaylist.get(pseudo).get(nomPlaylist).getVideos().add(v.get());

    }


    @Override
    public List<Playlist> getPlaylisByUser(String pseudo) throws AucunePlaylistExistantException {
        if (!userPlaylist.containsKey(pseudo))
            throw new AucunePlaylistExistantException();
        List<Playlist> list = new ArrayList<>();
        userPlaylist.get(pseudo).forEach((s, playlist) -> {
            list.add(playlist);
        });
        return list;
    }

    @Override
    public List<Video> getVideosUser(String pseudo) throws AucuneVideoExistantException {
        if (userVideos.containsKey(pseudo)) {

            List<Video> list = new ArrayList<>();
            userVideos.get(pseudo).forEach((s, video) -> {
                list.add(video);
            });
            return list;
        }
        throw new AucuneVideoExistantException();
    }

    @Override
    public List<Video> getAllVideos() throws AucuneVideoExistantException {
        List<Video> list = new ArrayList<>();
        userVideos.forEach((s, videos) -> {
            videos.forEach((s1, video) -> {
                list.add(video);
            });
        });
        if (!list.isEmpty())
            return list;
        throw new AucuneVideoExistantException();
    }

    @Override
    public Profil getProfil(String pseudo) throws UtilisateurInexistantException {
        List<Playlist> playlists = new ArrayList<>();
        List<Video> videos = new ArrayList<>();
        try {
            playlists = this.getPlaylisByUser(pseudo);
        } catch (AucunePlaylistExistantException e) {
            e.printStackTrace();
        }

        try {
            videos = this.getVideosUser(pseudo);
        } catch (AucuneVideoExistantException e) {
            e.printStackTrace();
        }
        return new Profil(pseudo, playlists, videos);

    }
}
