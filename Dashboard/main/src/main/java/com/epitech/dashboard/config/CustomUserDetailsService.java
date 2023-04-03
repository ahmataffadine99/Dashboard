package com.epitech.dashboard.config;

import com.epitech.dashboard.facade.FacadeUtilisateur;
import com.epitech.dashboard.facade.UtilisateurInexistantException;
import com.epitech.dashboard.modele.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomUserDetailsService implements UserDetailsService {

    private static final String[] ROLES_ADMIN = {"USER","ADMIN"};
    private static final String[] ROLES_USER = {"USER"};
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FacadeUtilisateur facadeUtilisateur;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        try {
            Utilisateur utilisateur = facadeUtilisateur.getUtilisateurByName(s);
            String[] roles = ROLES_USER;
            UserDetails userDetails = User.builder()
                    .username(utilisateur.getPseudo())
                    .password(passwordEncoder.encode(utilisateur.getMdp()))
                    .roles(roles)
                    .build();

            return userDetails;
        } catch (UtilisateurInexistantException e){
            throw  new UsernameNotFoundException("User "+s+" not found");
        }


    }
}
