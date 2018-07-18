package controllers.utilisateurs;

import controllers.Application;
import controllers.CRUD;
import controllers.Secure;
import models.Commandes.Client;
import models.Commandes.Commande;
import models.Commandes.Livraison;
import models.restaurants.Agent;
import models.restaurants.Categorie;
import models.restaurants.Plat;
import models.utilisateurs.Utilisateur;
import play.data.validation.Check;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.libs.Codec;
import play.mvc.Before;
import play.mvc.Catch;
import play.mvc.With;

import java.util.List;

import static play.data.validation.Validation.*;
import static play.db.jpa.GenericModel.count;



public class Utilisateurs extends CRUD{
    public static void compte() {
        render();
    }

    public static void addUtilisateur(
            @Required(message = "Type d'utilisateur obligatoire") String utilisateur,
            @Required(message = "Email obligatoire") String emailEng,
            @Required(message = "Login obligatoire") String loginEng,
            @Required(message = "Mot de passe obligatoire") String passwordEng) {
        if (hasErrors()) {
            render("Utilisateur/compte.html", utilisateur, emailEng, loginEng, passwordEng);
        }else
        if (utilisateur.equals("Client")) try {
            new Client(loginEng, Utilisateur.sethashpassword(passwordEng), emailEng, utilisateur).save();
            flash.success("Bienvenue %s", loginEng);
            render("restaurants/Clients/compte.html");
        } catch (Exception e) {
            addError("Login déja utilisé", loginEng);
            render("utilisateurs/Utilisateurs/compte.html");
        }
        else
        if (utilisateur.equals("Agent")) try {
            new Agent(loginEng, Utilisateur.sethashpassword(passwordEng), emailEng, utilisateur).save();
            flash.success("Bienvenue %s");
            render("utilisateurs/Utilisateurs/crudAgent.html");
        } catch (Exception e) {
            addError("Login déja", loginEng);
            render("utilisateurs/Utilisateurs/compte.html");
        }
    }



    public static void index() {
        render();
    }
    @controllers.Check("Agent")
    public static void crudAgent(){
        List<Categorie> categorieList = Categorie.findAll();
        List<Plat> plats = Plat.findAll();
        List<Commande> commandes = Commande.findAll();
        List<Livraison> livraisons = Livraison.findAll();
        render(categorieList, plats, commandes, livraisons);
    }

}


