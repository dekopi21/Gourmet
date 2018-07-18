package controllers.restaurants;

import controllers.Actions;
import controllers.CRUD;
import controllers.TypeImage;
import controllers.TypeUtilisateur;
import models.restaurants.Categorie;
import models.restaurants.Plat;
import play.data.validation.Required;

import java.io.File;
import java.util.List;

import static play.data.validation.Validation.hasErrors;

public class Plats extends CRUD{
    public static void plat(){
        List<Categorie> categories = Categorie.findAll();
        render(categories);
    }

    public static void indexPlat(){
        List<Categorie> categories = Categorie.findAll();
        List<Plat> plats = Plat.findAll();
        render(plats, categories);
    }

    public static void supPlat(
            @Required(message = "Oopps le champ id ne doit pas etre vide!!! ")Long idPlatSupp){
        if (hasErrors()) {
            redirect("restaurants/Plats/indexPlat.html", idPlatSupp);
        } else
        try {
            Plat plat = Plat.findById(idPlatSupp);
            plat.delete();
            flash.success("Plat%s","supprimer avec succes");
            render("restaurant/plat/indexPlat.html");
        } catch (Exception Ignore) {
            render("restaurants/plats/indexPlat.html");
        }
    }

    public static void modifPlat(
            @Required(message = "Oopps le champ id ne doit pas etre vide!!! ")Long idPlatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ")boolean despoPlatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ")String nomPlatModif,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!! ")String descPlatModif,
            @Required(message = "Oopps le champ Categorie ne doit pas etre vide!!! ")Long categPlatModif){
        if (hasErrors()) {
            render("/restaurants/Plats/indexPlat.html", nomPlatModif,  categPlatModif);
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
                render("restaurants/Plats/indexPlat.html");
            } catch (Exception Ignore) {
                render("restaurants/Plats/indexPlat.html");
            }
            }


    public static void addPlat(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!! ") String nomPlatEng,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descPlatEng,
            @Required(message = "Oopps le champ image ne doit pas etre vide!!!") File imagePlatEng,
            @Required(message = "Oopps le champ categorie ne doit pas etre vide!!!") Long categPlatEng) {
        if (hasErrors()) {
            render("/restaurants/Plats/indexPlat.html", nomPlatEng, imagePlatEng, categPlatEng);
        } else
            try {
                Categorie categorie = Categorie.findById(categPlatEng);
                new Plat(nomPlatEng, Actions.enregImage(imagePlatEng, TypeImage.PLATS, TypeUtilisateur.RAS), descPlatEng, true, categorie).save();
                flash.success("Plat%s", nomPlatEng + "\tenregistré avec succes");
                render("Plats/indexPlat.html");
            } catch (Exception Ignore) {
                render("Plats/indexPlat.html");
            }
    }

    public static void showPlats(Long idPlatShow){
                Plat plat = Plat.findById(idPlatShow);
                render(plat);
    }
}





