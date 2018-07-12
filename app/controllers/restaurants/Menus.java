package controllers.restaurants;

import models.restaurants.Menu;
import models.restaurants.TypeMenu;
import play.data.validation.Validation;

import java.util.Calendar;
import java.util.List;

public class Menus {

    public static void menu() {
        List<TypeMenu> typeMenus = TypeMenu.findAll();
        render(typeMenus);
    }

    public static void addMenu(String libelleEng, long typeMenuEng) {
        try{
            Menu menu = new Menu(libelleEng, TypeMenu.<TypeMenu>findById(typeMenuEng)).save();
            indexMenu();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");

        } catch (Exception e) {
            Validation.addError("échec", "Erreur d'enregistrement");
            render("client/show.html");
        }
    }

    public static void indexMenu(){
        List<Menu> menus = Menu.findAll();
        List<TypeMenu> typeMenus = TypeMenu.findAll();

        render(menus, typeMenus);
    }

    public static void suppMenu(Long idSupp){
        Menu menu = Menu.findById(idSupp);
        try {
            menu.delete();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            indexMenu();
        }catch (Exception e){
            Validation.addError("échec", "Erreur d'enregistrement");
        }
    }

    public static void modifMenu(Long idModif, String libelleModif, Long typeMenuModif, Calendar calendarModif) {
        Menu menu = Menu.findById(idModif);
        try {
            menu.setLibelle(libelleModif);
            menu.setTypeMenu(TypeMenu.<TypeMenu>findById(typeMenuModif));
            menu.setCalendrie(calendarModif);
            menu.save();
            flash.success("SUCCES %s", "Enregistremnt Bien Éffectué");
            indexMenu();
        } catch (Exception e) {
            Validation.addError("échec", "Erreur d'enregistrement");
        }

    }
}
