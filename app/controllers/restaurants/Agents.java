package controllers.restaurants;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import controllers.Security;
import models.Commandes.Client;
import models.restaurants.Agent;
import models.utilisateurs.Utilisateur;
import play.data.validation.Required;
import play.mvc.With;

import static play.data.validation.Validation.addError;
import static play.data.validation.Validation.hasErrors;

@With(Security.class)
@Check("Administrateur")
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
            redirect("portail.partenaire.Dashbords.dashboard");
        } catch (Exception e) {
            e.getStackTrace();
            flash.error("Login exist déja");

            redirect("utilisateurs.Utilisateurs.compte");
        }
    }

    public static void show(Long identifiant){
        render(Agent.findById(identifiant));
    }


}
