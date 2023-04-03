package com.epitech.dashboard.Controllers;


import com.epitech.dashboard.facade.*;
import com.epitech.dashboard.modele.Playlist;
import com.epitech.dashboard.modele.Profil;
import com.epitech.dashboard.modele.Utilisateur;
import com.epitech.dashboard.modele.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;


@RestController
@RequestMapping(value = "/myyoutubews", produces = MediaType.APPLICATION_JSON_VALUE)
public class DashboardController {

    @Autowired
    private FacadeUtilisateur facadeUtilisateur;
    @Autowired
    private FacadeVideosPlaylists facadeVideoPlaylist;

    @PostMapping(value = "/user", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> creerUtilisateur(@RequestBody Utilisateur utilisateur) {
        try {
            String id = this.facadeUtilisateur.enregistrerUtilisateur(utilisateur.getPseudo(),
                    utilisateur.getMdp());
            return ResponseEntity.created(URI.create("/authen")).body("L'utilisatuer à été" +
                    " enregistrer !");
        } catch (UtilisateurDejaExistantException | InformationManquanteException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Le pseudo " +
                    utilisateur.getPseudo() + "est dejas utilisé");
        }

    }

    /**
     * En résumé : je vire tous les tokens
     *
     * j'injecte en tant quie dernier paramatre le Principal (l'utilisateur authentifié injecté par Springsec)
     * @param
     * @param
     * @return
     */

    @PostMapping(value = "/user/{pseudo}/playlist", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> creerPlaylist(@PathVariable String pseudo,
                                                @RequestParam String nomPlaylist,
                                                UriComponentsBuilder base,
                                                Principal principal) {

        try {
            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {

                long id = this.facadeVideoPlaylist.creerPlaylist(pseudo, nomPlaylist);
                return ResponseEntity.created(base.path("/myyoutube/user/{idUser}/playlist/{id}")
                        .buildAndExpand(pseudo, id).toUri()).build();
            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        } catch (PlaylistPortantDejaMemeNomException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict de nom de playlist  ");
        }


    }

    @PostMapping(value = "/user/{pseudo}/depotVideo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> depotVideo(@PathVariable String pseudo,
                                             @RequestBody Video video,
                                             Principal principal) {

        try {
            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {
                this.facadeVideoPlaylist.depotVideo(pseudo, video);
                return ResponseEntity.status(HttpStatus.OK).body("Video ajouter avec succès");
            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict video dejas existant");
        }

    }

    @GetMapping(value = "/user/{pseudo}/playlist",
            produces = "application/json")
    public ResponseEntity<List<Playlist>> getUserPlaylist(@PathVariable String pseudo,
                                                          Principal principal) {



            String pseudoTken =principal.getName();
            if (pseudo.equals(pseudoTken)) {
                try {
                    List<Playlist> playlists = facadeVideoPlaylist.getPlaylisByUser(pseudo);
                    return new ResponseEntity<>(playlists, HttpStatus.OK);

                } catch (AucunePlaylistExistantException e) {

                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }

            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();




    }

    @GetMapping(value = "/user/{pseudo}/videos", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = "application/json")
    public ResponseEntity<List<Video>> getUserVideos( Principal principal,
                                                     @PathVariable String pseudo) {


            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {
                try {
                    List<Video> videos = facadeVideoPlaylist.getVideosUser(pseudo);
                    return new ResponseEntity<>(videos, HttpStatus.OK);

                } catch (AucuneVideoExistantException e) {

                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }

            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();



    }

    @GetMapping(value = "/user/videos/{pseudo}",
            produces = "application/json")
    public ResponseEntity<List<Video>> getAllVideos(@PathVariable String pseudo, Principal principal) {


            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {
                try {
                    List<Video> videos = facadeVideoPlaylist.getAllVideos();
                    return new ResponseEntity<>(videos, HttpStatus.OK);

                } catch (AucuneVideoExistantException e) {

                    return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
                }

            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();



    }


    @PostMapping(value = "/user/{pseudo}/{nomPlaylist}/{titreVideo}/videos",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> addVideosPlaylist(@PathVariable String pseudo,
                                                    @PathVariable String nomPlaylist,
                                                    @PathVariable String titreVideo,
                                                    Principal principal) {



            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {


                try {
                    facadeVideoPlaylist.ajoutVideoPlaylist(pseudo, titreVideo, nomPlaylist);
                    return ResponseEntity.status(HttpStatus.OK).body("Video ajouter avec succès");

                } catch (VideoPortantDejaMemeNomException e) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict video dejas existant");
                }


            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();



    }


    @GetMapping(value = "/user/{pseudo}/profil", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = "application/json")
    public ResponseEntity<Profil> getProfil( Principal principal,
                                            @PathVariable String pseudo) {



            String pseudoTken = principal.getName();
            if (pseudo.equals(pseudoTken)) {
                try {
                    Profil profil = facadeVideoPlaylist.getProfil(pseudo);
                    return new ResponseEntity<>(profil, HttpStatus.OK);
                } catch (UtilisateurInexistantException e) {
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
                }

            } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();



    }
}
