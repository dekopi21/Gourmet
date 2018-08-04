package controllers.portail;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.restaurants.Categorie;
import models.restaurants.DatePrix;
import models.restaurants.Plat;
import models.restaurants.Restaurant;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
@Check("Agent")
public class Dashboards extends CRUD {
    public static void dashboard(){
        render();
    }
    public static void restaurant(){
       Restaurant restaurant =  Restaurant.find("").first();
        List<Categorie> categorie = Categorie.find("order by nom asc").fetch(6);
        render(restaurant,categorie);
    }

    public static void AccueilPlat(){
        render();
    }
}
