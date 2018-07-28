package controllers.portail;

import controllers.CRUD;
import models.restaurants.Categorie;
import models.restaurants.DatePrix;
import models.restaurants.Plat;
import models.restaurants.Restaurant;

import java.util.List;

public class Dashboards extends CRUD {
    public static void dashboard(){
        render();
    }
    public static void restaurant(){
       Restaurant restaurant =  Restaurant.find("").first();
        List<Categorie> categorie = Categorie.find("order by nom asc").fetch(6);
        List<Plat> plats = Plat.findAll();
        List<DatePrix> datePrixes = DatePrix.findAll();
        render(restaurant,categorie, plats,datePrixes);
    }
}
