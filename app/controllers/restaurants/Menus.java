package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.Menu;
import models.restaurants.TypeMenu;
import play.data.validation.Required;
import play.data.validation.Validation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Menus extends CRUD {

    public static void menu() {
        List<TypeMenu> typeMenus = TypeMenu.findAll();
        render(typeMenus);
    }

    public static void addMenu(
            @Required(message = "le champ libelle est obligatoire") String libelleEng,
            @Required(message = "le champ type menu est obligatoire") long typeMenuEng) {
        try{
            Menu menu = new Menu(libelleEng, TypeMenu.<TypeMenu>findById(typeMenuEng)).save();
            flash.success("SUCCES %s\t", "Enregistremnt Bien Éffectué");
            redirect("controllers.restaurants.Menus.listMenu");

        } catch (Exception e) {
            flash.error("Menu enrégistré avec succes");
            redirect("controllers.restaurants.Menus.menu");
        }
    }

    public static void listMenu(){
        List<Menu> menus = Menu.find("order by id desc").fetch(8);
        List<TypeMenu> typeMenus = TypeMenu.findAll();
        render(menus, typeMenus);
    }

    public static void suppMenu(
            @Required(message = "l'identifiant de l'enregistrement est introuvable") Long idSupp){

        try {
            Menu menu = Menu.findById(idSupp);
            menu.delete();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            redirect("controllers.restaurants.Menus.listMenu");
        }catch (Exception e){
            flash.error("Suppression non éffectué");
            redirect("controllers.restaurants.Menus.listMenu");
        }
    }

    public static void modifMenu(
            @Required(message = "L'identifiant de l'enregistrement est introuvable") Long idModif,
            @Required(message = "le libelle de la mofification n'est pas selection") String libelleModif,
            @Required(message = "le Type de menu est non definie") Long typeMenuModif
            ) {
        Menu menu = Menu.findById(idModif);
        try {
            menu.setLibelle(libelleModif);
            menu.setTypeMenu(TypeMenu.<TypeMenu>findById(typeMenuModif));
            menu.setCalendrie(new GregorianCalendar());
            menu.save();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            redirect("controllers.restaurants.Menus.listMenu");
        } catch (Exception e) {
            flash.error("Modificstion non éffectué");
            redirect("controllers.restaurants.Menus.listMenu");
        }

    }
}
