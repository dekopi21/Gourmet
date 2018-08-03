package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.Categorie;
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

    public static void infoResto(){
        Restaurant restaurant = Restaurant.find("").first();
        render(restaurant);
    }
        public static void entrer(){
        Restaurant restaurant = Restaurant.find("").first();
        render(restaurant);
    }
        public static void categorie(){
            List<Categorie> categorie = Categorie.find("order by nom asc").fetch(6);
        render(categorie);
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

    public static void descriptionResto(){
                Restaurant restaurant = Restaurant.find("").first();
                render(restaurant);
    }
}
