package controllers.commandes;

import controllers.*;
import models.Commandes.Livreur;
import models.Commandes.Commande;

import models.utilisateurs.Utilisateur;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.With;

import java.io.File;
import java.util.List;

@With(Security.class)
@Check({"Agent","Administrateur"})
public class Livreurs extends CRUD{
    /**
     *
     */
    public static void Livreur() {
        render();
    }

    public static void show(Long id) {
        Livreur livreur = Livreur.findById(id);
        render(livreur);
    }

    public static void addLivreur(@Required(message = "valeur non null")String loginEng,
                                  @Required(message = "valeur non null")String passwordEng,
                                  @Required(message = "valeur non null")String nomUtilisateurEng,
                                  @Required(message = "valeur non null")String prenomUtilisateurEng,
                                  @Required(message = "valeur non null")String emailEng,
                                  @Required(message = "valeur non null")String sexeEng,
                                  @Required(message = "valeur non null")String telephoneEng,
                                  @Required(message = "valeur non null")String civiliteEng,
                                  @Required(message = "valeur non null")String villeEng,
                                  @Required(message = "valeur non null")String quartierEng,
                                  @Required(message = "valeur non null")File imagePlatEng) {
        if (Validation.hasErrors()){

        }
        try {
            System.out.println("je suis arrivé ici");
            Livreur client = new Livreur();
            client.setVille(villeEng);
            client.setQuartier(quartierEng);
            client.setCivilite(civiliteEng);
            client.setEmail(emailEng);
            client.setLogin(loginEng);
            client.setImage(Actions.enregImage(imagePlatEng, TypeImage.UTILISATEURS, TypeUtilisateur.LIVREUR));
            client.setNomUtilisateur(nomUtilisateurEng);
            client.setPassword(Utilisateur.sethashpassword(passwordEng));
            client.setPrenomUtilisateur(prenomUtilisateurEng);
            client.setSexe(sexeEng.charAt(0));
            client.setTelephone(telephoneEng);
            client.save();

            flash.success("Livreur enregistré avec succes");
            render();
        } catch (Exception e) {
            flash.error("Ce livreur exist déja");
            render();
        }
    }


    public static void supprimerLivreur(Long id) {
        Livreur livreur = Livreur.findById(id);
        try {
            livreur.delete();
            index();
        } catch (Exception ignore) {
            Validation.addError("échec", "Erreur!! suppression non éffectué");
        }
    }

    private static void index() {
        List<Livreur> livreurList = Livreur.findAll();
        render(livreurList);
    }

    public static void modifierLivreur(Long id, Livreur livreur) {
        Livreur livreur1 = Livreur.findById(id);
        livreur1 = livreur;
        livreur.save();
        show(id);
    }

    public static void crudLivreur(){
        List<Livreur> livreurs = Livreur.findAll();
        List<Commande> commandes = Commande.findAll();
        render(livreurs, commandes);
    }

}
