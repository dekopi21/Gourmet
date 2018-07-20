package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.Categorie;
import play.data.validation.Required;
import java.util.List;

import static play.data.validation.Validation.*;

public class Categories extends CRUD{
    public static void indexCategorie(){
        List<Categorie> categories = Categorie.findAll();
        render(categories);
    }

    public static void addCategorie(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") String nomCatEng,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descCatEng){
        if (hasErrors()) {
            render("utilisateurs/Utilisateurs/crudAgent.html",nomCatEng);
        }else
        try{
            //TODO verifier la methode flash.secces
            new Categorie(nomCatEng, descCatEng).save();
            flash.success("Categorie enregistré avec succes");
            redirect("utilisateurs.Utilisateurs.crudAgent");
        }catch (Exception Ignore){
            flash.error("Oopps Catégorié%s", nomCatEng+"déja existant!!");
                redirect("utilisateurs.Utilisateurs.crudAgent");
        }
    }

    public static void categorie(){
                render();
    }
}
