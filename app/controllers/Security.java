package controllers;

import models.utilisateurs.Utilisateur;

public class Security extends Secure.Security {

    static boolean authentify(String username, String password) {
       return(Utilisateur.connect(username, password) != null) ;
    }

    static boolean check(String profile) {
        if ("Agent".equals(profile) || "Livreur".equals(profile) || "Client".equals(profile)) {
            return Boolean.parseBoolean(Utilisateur.find("byEmail", connected()).<Utilisateur>first().getProfile());
        }
        return "Administrateur".equals(profile) && Boolean.parseBoolean(Utilisateur.find("byEmail", connected()).<Utilisateur>first().getProfile());
    }
}
