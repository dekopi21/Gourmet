package controllers.restaurants;
import controllers.Actions;
import controllers.CRUD;
import controllers.TypeImage;
import controllers.TypeUtilisateur;
import models.restaurants.Categorie;
import play.data.validation.Required;
import play.data.validation.Validation;

import java.io.File;
import java.util.List;

import static play.data.validation.Validation.*;

public class Categories extends CRUD{
    public static void indexCategorie(){
        List<Categorie> categories = Categorie.findAll();
        render(categories);
    }

    public static void addCategorie(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") String nomCatEng,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descCatEng,
            @Required(message = "Oopps le champ image ne doit pas etre vide!!!")File imageCatEng ){
        if (hasErrors()) {
            render("/restaurants/Categories/indexCategorie.html",nomCatEng,imageCatEng);
        }else
        try{
            new Categorie(nomCatEng, descCatEng, Actions.enregImage(imageCatEng, TypeImage.CATEGORIES, TypeUtilisateur.RAS)).save();
            flash.success("Categorie%s",nomCatEng+"\tenregistré avec succes");
            render("Categories/indexCategorie.html");
        }catch (Exception Ignore){
            addError("Oopps Catégorié%s", nomCatEng+"déja existant!!");
                render("Categories/indexCategorie.html");
        }
    }

    public static void categorie(){
                render();
    }
}
