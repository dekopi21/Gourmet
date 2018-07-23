package controllers;

import models.Commandes.Client;
import models.restaurants.Agent;
import models.restaurants.Plat;
import models.utilisateurs.Utilisateur;
import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        List<Plat> fromPlat = Plat.find("order by image desc").from(1).fetch(8);
        Plat encienPlat = Plat.find("order by image desc").first();
        render(fromPlat, encienPlat);
    }

    public static void cart(Long idClient){

        render();
    }

    public static void test(){
        List<Agent> agents = Agent.findAll();
        render("Agent/list.html", agents);
    }



}