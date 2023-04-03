package com.epitech.dashboard.modele;

import java.time.LocalDateTime;

public class Utilisateur {
    private String pseudo;
    private String mdp;
    private LocalDateTime dateInscription;

    public Utilisateur(String pseudo, String mdp) {
        this.pseudo = pseudo;
        this.mdp = mdp;
        this.dateInscription = LocalDateTime.now();
    }

    public Utilisateur() {
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public LocalDateTime getDateInscription() {
        return dateInscription;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}
