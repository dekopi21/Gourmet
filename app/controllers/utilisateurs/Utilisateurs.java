package controllers.utilisateurs;

import controllers.CRUD;
import models.Commandes.Client;
import models.restaurants.Agent;
import play.data.validation.Required;

public class Utilisateurs extends CRUD{
    public static void compte() {
        render();
    }

    public static void addUtilisateur(
            @Required(message = "Type d'utilisateur obligatoire") String utilisateur,
            @Required(message = "Email obligatoire") String emailEng,
            @Required(message = "Login obligatoire") String loginEng,
            @Required(message = "Mot de passe obligatoire") String passwordEng) {
        if (validation.hasErrors()) {
            render("Utilisateur/compte.html", utilisateur, emailEng, loginEng, passwordEng);
        }
        if (utilisateur.equals("Client")) {
            try {
                new Client(loginEng, passwordEng, emailEng).save();
                flash.success("SUCCES", loginEng, utilisateur);
                render("utilisateurs/Utilisateurs/compte.html");
            } catch (Exception e) {
                validation.addError("ECHEC", loginEng + "\t" + emailEng + "\t" + passwordEng, utilisateur);
                render("utilisateurs/Utilisateurs/compte.html");
            }
        }
        if (utilisateur.equals("Agent")) {
            try {
                new Agent(loginEng, passwordEng, emailEng).save();
                flash.success("SUCCES", "Enregistrement éffectué");
                render("utilisateurs/Utilisateurs/compte.html");
            } catch (Exception e) {
                validation.addError("ECHEC", "Enregistrement non Effectué");
                render("utilisateurs/Utilisateurs/compte.html", loginEng, utilisateur, emailEng, passwordEng);
            }
        }
    }

}
