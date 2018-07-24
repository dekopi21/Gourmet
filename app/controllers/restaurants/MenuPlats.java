package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.Menu;
import models.restaurants.MenuPlat;
import models.restaurants.Plat;
import play.data.validation.Required;
import play.db.jpa.JPABase;

import java.util.List;


public class MenuPlats extends CRUD{
    public static void listMP(){
        List<MenuPlat> menuPlat = MenuPlat.findAll();
        render(menuPlat);
    }

    public static void addMP(
            @Required(message = "")Long idMenu,
            @Required(message =  "")Long idPlat){
        try {
    new MenuPlat(Menu.<Menu>findById(idMenu), Plat.<Plat>findById(idPlat)).save();
    flash.success("");
    redirect("controllers.restaurants.MenuPlats.listMP");
        }catch (Exception Ignore){
        flash.error("Erreur");
        redirect("controllers.restaurants.MenuPlats.menuplat");
        }

    }




    public static void menuplat(){
        List<Menu> menu = Menu.findAll();
        List<Plat> plat = Plat.findAll();
        render(menu, plat);
    }
}
