package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.Menu;
import models.restaurants.Restaurant;
import models.restaurants.TypeMenu;
import play.data.validation.Required;

import java.util.List;
import java.util.logging.LoggingMXBean;

public class Restaurants extends CRUD{
    public static void index() {
        render();
    }

    public static void dish_select() {
        render();
    }

    public static void addResto(){

    }

    public static void modifResto(
            @Required(message = "") Long idResto,
            @Required(message = "") String nom,
            @Required(message = "") String raisonSocial,
            @Required(message = "") String loccalisation,
            @Required(message = "") String image){
        try {
            Restaurant restaurant = Restaurant.findById(idResto);
            restaurant.setNom(nom);
            restaurant.setRaisonSocial(raisonSocial);
            restaurant.setLocalisation(loccalisation);
            restaurant.setImage(image);
            restaurant.save();
            flash.success("");
            redirect("");
        }catch (Exception Ignore){
            flash.error("");
            redirect("");
        }
    }
}
