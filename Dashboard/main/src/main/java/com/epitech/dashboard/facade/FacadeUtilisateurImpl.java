package com.epitech.dashboard.facade;

import com.epitech.dashboard.modele.Utilisateur;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component("facadeUtilisateur")
public class FacadeUtilisateurImpl implements FacadeUtilisateur {
    private static final String BEARER = "Bearer";
    private Map<String, Utilisateur> utilisateurs;

    public FacadeUtilisateurImpl() {
        this.utilisateurs = new HashMap<>();
    }

    @Override
    public String enregistrerUtilisateur(String pseudo, String mdp) throws UtilisateurDejaExistantException, InformationManquanteException {

        if (Objects.isNull(pseudo) || Objects.isNull(mdp) || pseudo.isEmpty() || mdp.isEmpty())
            throw new InformationManquanteException();
        if (utilisateurs.containsKey(pseudo))
            throw new UtilisateurDejaExistantException();
        else {
            Utilisateur utilisateur = new Utilisateur(pseudo, mdp);

            this.utilisateurs.put(pseudo, utilisateur);
            return utilisateur.getPseudo();
        }
    }

    @Override
    public void checkUtilisateur(String pseudo, String mdp) throws UtilisateurInexistantException, DonneeIncoherentExecption {
        Utilisateur utilisateur = utilisateurs.get(pseudo);
        if (Objects.isNull(utilisateurs))
            throw new UtilisateurInexistantException();
        else {
            if (!utilisateur.getMdp().equals(mdp)) {
                throw new DonneeIncoherentExecption();
            }
        }
    }
    /**

    @Override
    public String genererTokenAuthentification(String pseudo, String mdp) throws UtilisateurInexistantException,
            DonneeIncoherentExecption {
        this.checkUtilisateur(pseudo, mdp);
        return BEARER + pseudo;
    }

    @Override
    public String dechiffrerToken(String token) throws BadTokenException {
        if (BEARER.equals(token.substring(0, BEARER.length()))) {
            return token.substring(BEARER.length());
        } else throw new BadTokenException();
    }

     **/
    @Override
    public Utilisateur getProfile(String pseudo) throws UtilisateurInexistantException {
        if (utilisateurs.containsKey(pseudo)) return utilisateurs.get(pseudo);
        throw new UtilisateurInexistantException();
    }

    @Override
    public Utilisateur getUtilisateurByName(String s) throws UtilisateurInexistantException {
        if (utilisateurs.containsKey(s)) return utilisateurs.get(s);
            throw new UtilisateurInexistantException();
    }
}
