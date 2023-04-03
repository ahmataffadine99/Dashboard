package com.epitech.dashboard.facade;

import com.epitech.dashboard.modele.Utilisateur;


public interface FacadeUtilisateur {
    /**
     * Nous permet d'eregistrer un utilisateur
     *
     * @param pseudo
     * @param mdp
     * @return
     * @throws UtilisateurDejaExistantException le login est déja pris
     */
    String enregistrerUtilisateur(String pseudo, String mdp) throws UtilisateurDejaExistantException, InformationManquanteException;

    /**
     * Permet de verifier la validité de l'utilisateur
     *
     * @param pseudo
     * @param mdp
     * @throws UtilisateurInexistantException l'utilasateur n'est pas connu
     * @throws DonneeIncoherentExecption      login/mdp n'est pas connu
     */
    void checkUtilisateur(String pseudo, String mdp) throws UtilisateurInexistantException,
            DonneeIncoherentExecption;

    /**
    String genererTokenAuthentification(String idUser, String mdp) throws UtilisateurInexistantException, DonneeIncoherentExecption;

    String dechiffrerToken(String token) throws BadTokenException;
     **/

    Utilisateur getProfile(String pseudo) throws UtilisateurInexistantException;

    Utilisateur getUtilisateurByName(String s) throws UtilisateurInexistantException;
}
