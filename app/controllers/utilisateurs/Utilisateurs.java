package controllers.utilisateurs;

import controllers.CRUD;
import models.Commandes.Client;
import models.utilisateurs.Utilisateur;

import java.util.List;

public class Utilisateurs extends CRUD {
    public static void compte() {
        List<Utilisateur> utilisateurs = Utilisateur.findAll();
        render(utilisateurs);
    }

    public static void addUtilisateur(String utilisateur, String emailEng, String loginEng, String passwordEng) {
        if (utilisateur.equals("Client")) {
            Client client = new Client();
        }
    }

}
