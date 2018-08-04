package controllers.restaurants;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.restaurants.Categorie;
import play.data.validation.Required;
import play.mvc.With;

import java.util.List;

import static play.data.validation.Validation.*;

@With(Secure.class)
public class Categories extends CRUD{

    @Check("Agent")
    public static void addCategorie(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") String nomCatEng,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descCatEng){
        if (hasErrors()) {
            redirect("controllers.restaurants.Categories.listCat");
        }else
        try{
            new Categorie(nomCatEng, descCatEng).save();
            flash.success("Categorie enregistré avec succes");
            redirect("controllers.restaurants.Categories.listCat");
        }catch (Exception Ignore){
            flash.error("Oopps Catégorié%s", nomCatEng+"déja existant!!");
            redirect("controllers.restaurants.Categories.categorie");
        }
    }

    @Check("Agent")
    public static void categorie(){
                render();
    }

    @Check("Agent")
    public static void listCat(){
        List<Categorie>  categorieList = Categorie.find("order by id desc").fetch(12);
        render(categorieList);
    }

    @Check("Agent")
    public static void modifCategorie(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") Long idCatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") String nomCatModif,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descCatModif){
        if (hasErrors()) {
            redirect("controllers.restaurants.Categories.listCat");
        }else
            try{
                Categorie categorie = Categorie.findById(idCatModif);
                categorie.setNom(nomCatModif);
                categorie.setDescription(descCatModif);
                categorie.save();
                flash.success("Categorie enregistré avec succes");
                redirect("controllers.restaurants.Categories.listCat");
            }catch (NullPointerException Ignore){
                flash.error("Oopps cette catégorié  ne peut pas etre modifier!! Null");
                redirect("controllers.restaurants.Categories.listCat");
            }
    }
    @Check("Agent")
    public static void suppCat(
        @Required(message = "Oopps l'identifiant est introuvable sur le formulaire") Long idCatSup){
        if (hasErrors()) {
            redirect("controllers.restaurants.Categories.listCat");
        }else
            try{
                Categorie categorie = Categorie.findById(idCatSup);
                categorie.delete();
                flash.success("Categorie supprimé avec succes");
                redirect("controllers.restaurants.Categories.listCat");
            }catch (Exception Ignore){
                flash.error("Oopps cette catégorié  ne peut pas etre modifier");
                redirect("controllers.restaurants.Categories.listCat");
            }
    }

    @Check("Agent")
    public static void showCat(Long id){
            Categorie categorie = Categorie.findById(id);
    }

}
