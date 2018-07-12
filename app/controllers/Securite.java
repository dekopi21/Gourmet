package controllers;

import models.utilisateurs.Utilisateur;

public class Securite extends Secure.Security {

    static boolean authenticate(String username, String password) {

        return Utilisateur.isValidLogin(username, password);
    }

    static boolean check(String profile) {
        Utilisateur administrateur = Utilisateur.find("byUsername", connected()).first();
        if ("Administrateur".equals(profile)) {
            return true;
        } else {
            return false;
        }
    }

    static void onAuthenticated() {

        Utilisateur user = getUser();
        String url = session.get("url");
        if (url != null) {
            session.remove("url");
            redirect(url);
        }
        if (Secure.Security.check("Agent")) {
            controllers.restaurants.Agents.index();
        }
        if (Secure.Security.check("Cleint")) {
            controllers.commandes.Clients.client();
        }
        if (Secure.Security.check("Livreur")) {
            controllers.commandes.Livreurs.Livreur();
        }


    }

    public static Utilisateur getUser() {
        // username is an email
        Utilisateur user = Utilisateur.find("byLogin", Securite.connected()).first();
        return user;
    }

}
