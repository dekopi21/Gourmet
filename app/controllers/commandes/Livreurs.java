package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.Commandes.Livreur;
import models.Commandes.Commande;

import play.data.validation.Validation;
import play.mvc.With;

import java.util.List;


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

    public static void addLivreur(String loginEng, String passwordEng, String nomUtilisateurEng,
                                     String prenomUtilisateurEng, String emailEng, char sexeEng, String telephoneEng,
                                     String civiliteEng, String villeEng, String quartierEng) {
        try {
            Livreur client = new Livreur();
            client.setVille(villeEng);
            client.setQuartier(quartierEng);
            client.setCivilite(civiliteEng);
            client.setEmail(emailEng);
            client.setLogin(loginEng);
            client.setImage("/public");
            client.setNomUtilisateur(nomUtilisateurEng);
            client.setPassword(passwordEng);
            client.setPrenomUtilisateur(prenomUtilisateurEng);
            client.setSexe(sexeEng);
            client.setTelephone(telephoneEng);
            client.save();

            flash.success("Livreur enregistré avec succes");
            render("");
        } catch (Exception e) {
            flash.error("Ce livreur exist déja");
            render("");
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
