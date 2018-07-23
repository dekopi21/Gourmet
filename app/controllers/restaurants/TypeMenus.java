package controllers.restaurants;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.restaurants.TypeMenu;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.With;

import java.util.List;



//@With(Secure.class)
//@Check("Adminstrateur")
public class TypeMenus extends CRUD{
    public static void addTypeMenu(
            @Required(message = "le champ libelle ne doit pas etre vide") String libelleEng,
            @Required(message = "le champ description ne doit pas etre vide") String descriptionEng){
        try{
            TypeMenu typeMenu = new TypeMenu(libelleEng, descriptionEng).save();
            flash.success("Enregistremnt bien Éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");

        } catch (Exception e) {
            flash.error("le type de menu existe déja ou n'a pas été enrégistré");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }
    }

    public static void typemenu(){
        render();
    }

    public static void indexTypeMenu(){
        List<TypeMenu> typeMenuList = TypeMenu.findAll();
        render(typeMenuList);
    }

    public static void modifTypeMenu(
            @Required(message = "L'identifiant est introuvable") Long idModif,
            @Required(message = "le champ libelle est obligatoire") String libelleModif,
            @Required(message = "le champ description est obligatoire") String descriptionModif){
        TypeMenu typeMenu = TypeMenu.findById(idModif);
        try {
            typeMenu.setLibelle(libelleModif);
            typeMenu.setDescription(descriptionModif);
            typeMenu.save();
            flash.success("Modification éffectué avec succes");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }catch (Exception e){
            flash.error("Erreur de modification ");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");

        }
    }

    public static void index(){
        render();
    }

    public static void suppTypeMenu(
            @Required(message = "L'identifiant est introuvable sur le formulaire") Long idSupp){
        try {
            TypeMenu typeMenu = TypeMenu.findById(idSupp);
            typeMenu.delete();
            flash.success("Suppression bien Éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }catch (Exception e){
            flash.error("Suppression non éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");

        }
    }
}
