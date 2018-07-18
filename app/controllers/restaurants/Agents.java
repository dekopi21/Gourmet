package controllers.restaurants;

import controllers.CRUD;
import models.Commandes.Client;
import models.restaurants.Agent;
import models.utilisateurs.Utilisateur;
import play.data.validation.Required;

import static play.data.validation.Validation.addError;
import static play.data.validation.Validation.hasErrors;

public class Agents extends CRUD{
    public static void index() {
        render();
    }

    public static void addAgent(
            @Required(message = "Email obligatoire") String emailEng,
            @Required(message = "Login obligatoire") String loginEng,
            @Required(message = "Mot de passe obligatoire") String passwordEng) {
        if (hasErrors()) {
            render("Utilisateur/compte.html", emailEng, loginEng, passwordEng);
        }else
        try {
            new Agent(loginEng, Utilisateur.sethashpassword(passwordEng), emailEng, "Agent").save();
            flash.success("Bienvenue %s");
            redirect("utilisateurs.Utilisateurs.crudAgent.html");
        } catch (Exception e) {
            flash.error("Login exist déja");
            render("utilisateurs/Utilisateurs/compte.html");
        }
    }


}
