package controllers.commandes;

import models.Commandes.Livreur;
import play.data.validation.Validation;

import java.util.List;

public class Livreurs {
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
                                     String civiliteEng, String villeEng, String quartierEng, String imageEng) {
        try {
            Livreur client = new Livreur();
            client.setVille(villeEng);
            client.setQuartier(quartierEng);
            client.setCivilite(civiliteEng);
            client.setEmail(emailEng);
            client.setLogin(loginEng);
            client.setImage(imageEng);
            client.setNomUtilisateur(nomUtilisateurEng);
            client.setPassword(passwordEng);
            client.setPrenomUtilisateur(prenomUtilisateurEng);
            client.setSexe(sexeEng);
            client.setTelephone(telephoneEng);
            client.save();

            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");

        } catch (Exception e) {
            Validation.addError("échec", "Erreur d'enregistrement");
            render("client/show.html");
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

}
