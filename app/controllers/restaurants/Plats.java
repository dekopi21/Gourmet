package controllers.restaurants;

import controllers.*;
import models.restaurants.Categorie;
import models.restaurants.Plat;
import models.utilisateurs.Utilisateur;
import play.data.validation.Required;
import play.mvc.With;

import java.io.File;
import java.util.List;

import static play.data.validation.Validation.hasErrors;

@With(Security.class)
@Check("Agent")
public class Plats extends CRUD{
    @Check("Agent")
    public static void plat(){
        List<Categorie> categories = Categorie.findAll();
        render(categories );
    }


    public static void accueilPlats(){
        List<Plat> platList = Plat.findAll();
        render(platList);
    }


    public static void listPlat(){
        List<Categorie> categories = Categorie.findAll();
        List<Plat> plats = Plat.find("order by id desc").fetch(5);
        render(plats, categories);
    }
@Check("Agent")
    public static void supPlat(
            @Required(message = "Oopps le champ id ne doit pas etre vide!!! ")Long idPlatSupp){
        if (hasErrors()) {
            redirect("portail.Dashboards.AccueilAgent");
        } else
        try {
            Plat plat = Plat.findById(idPlatSupp);
            plat.delete();
            flash.success("Plat supprimer avec succes");
            redirect("portail.Dashboards.AccueilAgent");

        } catch (Exception Ignore) {
            flash.error("impossible d'éffectué la suppression");
            redirect("portail.Dashboards.AccueilAgent");
        }
    }
    @Check("Agent")
    public static void modifPlat(
            @Required(message = "Oopps le champ id ne doit pas etre vide!!! ")Long idPlatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ")boolean despoPlatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ")String nomPlatModif,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!! ")String descPlatModif,
            @Required(message = "Oopps le champ Categorie ne doit pas etre vide!!! ")Long categPlatModif){
        if (hasErrors()) {
            redirect("portail.Dashboards.AccueilAgent");
        } else
            try {
            Plat plat = Plat.findById(idPlatModif);
            Categorie categorie = Categorie.findById(categPlatModif);
            plat.setCategorie(categorie);
            plat.setDisponible(despoPlatModif);
            plat.setDescription(descPlatModif);
            plat.setNomPlat(nomPlatModif);
            plat.save();

                flash.success("Plat%s", nomPlatModif + "\tModifié avec succes");
                redirect("portail.Dashboards.AccueilAgent");
        } catch (Exception Ignore) {
            flash.error("Modification non effectuée");
                redirect("portail.Dashboards.AccueilAgent");
        }
            }

    @Check("Agent")
    public static void addPlat(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ") String nomPlatEng,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descPlatEng,
            @Required(message = "Oopps le champ Image ne doit pas etre vide!!!") File imagePlatEng,
            @Required(message = "Oopps le champ categorie ne doit pas etre vide!!!") Long categPlatEng) {
        if (hasErrors()) {
            redirect("controllers.restaurants.Plats.listPlat");
        } else
            try {
                Categorie categorie = Categorie.findById(categPlatEng);
                new Plat(nomPlatEng, Actions.enregImage(imagePlatEng, TypeImage.PLATS, TypeUtilisateur.RAS), descPlatEng, true, categorie).save();
                flash.success("Plat \t", nomPlatEng + "\tenregistré avec succes");
                redirect("portail.Dashboards.AccueilAgent");
        } catch (Exception Ignore) {
                flash.error("Plat n\'est pas enregistré");
                redirect("portail.Dashboards.AccueilAgent");
        }
    }
    @Check("Agent")
    public static void showPlats(Long idPlatShow){
                Plat plat = Plat.findById(idPlatShow);
                render(plat);
    }
}





