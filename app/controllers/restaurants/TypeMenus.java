package controllers.restaurants;

import controllers.CRUD;
import controllers.Secure;
import models.restaurants.TypeMenu;
import play.data.validation.Validation;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
public class TypeMenus extends CRUD {
    public static void addTypeMenu(String libelleEng, String descriptionEng){
        try{
            TypeMenu typeMenu = new TypeMenu(libelleEng, descriptionEng).save();
                indexTypeMenu();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");

        } catch (Exception e) {
            Validation.addError("échec", "Erreur d'enregistrement");
            render("client/show.html");
        }
    }

    public static void typemenu(){
        render();
    }

    public static void indexTypeMenu(){
        List<TypeMenu> typeMenuList = TypeMenu.findAll();
        render(typeMenuList);
    }

    public static void modifTypeMenu(Long idModif,String libelleModif, String descriptionModif){
        TypeMenu typeMenu = TypeMenu.findById(idModif);
        try {
            typeMenu.setLibelle(libelleModif);
            typeMenu.setDescription(descriptionModif);
            typeMenu.save();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            indexTypeMenu();
        }catch (Exception e){
            Validation.addError("échec", "Erreur d'enregistrement");
        }
    }

    public static void suppTypeMenu(Long idSupp){
        TypeMenu typeMenu = TypeMenu.findById(idSupp);

        try {
            typeMenu.delete();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            indexTypeMenu();
        }catch (Exception e){
            Validation.addError("échec", "Erreur d'enregistrement");
        }
    }
}
