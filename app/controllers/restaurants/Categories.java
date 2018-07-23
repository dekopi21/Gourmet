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
            redirect("utilisateurs.Utilisateurs.crudAgent",nomCatEng);
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

    public static void modifCategorie(
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") Long idCatModif,
            @Required(message = "Oopps le champ Nom ne doit pas etre vide!!!") String nomCatModif,
            @Required(message = "Oopps le champ description ne doit pas etre vide!!!") String descCatModif){
        if (hasErrors()) {
            redirect("utilisateurs.Utilisateurs.crudAgent");
        }else
            try{
                Categorie categorie = Categorie.findById(idCatModif);
                categorie.setNom(nomCatModif);
                categorie.setDescription(descCatModif);
                categorie.save();
                flash.success("Categorie enregistré avec succes");
                redirect("utilisateurs.Utilisateurs.crudAgent");
            }catch (NullPointerException Ignore){
                flash.error("Oopps cette catégorié  ne peut pas etre modifier!! Null");
                redirect("utilisateurs.Utilisateurs.crudAgent");
            }
    }

    public static void suppCat(
        @Required(message = "Oopps l'identifiant est introuvable sur le formulaire") Long idCatSup){
        if (hasErrors()) {
            redirect("utilisateurs.Utilisateurs.crudAgent");
        }else
            try{
                Categorie categorie = Categorie.findById(idCatSup);
                categorie.delete();
                flash.success("Categorie supprimé avec succes");
                redirect("utilisateurs.Utilisateurs.crudAgent");
            }catch (Exception Ignore){
                flash.error("Oopps cette catégorié  ne peut pas etre modifier");
                redirect("utilisateurs.Utilisateurs.crudAgent");
            }
    }

}
