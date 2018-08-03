package controllers;

import models.Commandes.Client;
import models.Commandes.TypeReglement;
import models.restaurants.Agent;
import models.restaurants.DatePrix;
import models.restaurants.Plat;
import models.utilisateurs.Utilisateur;
import play.*;
import play.cache.Cache;
import play.mvc.*;

import java.util.*;

import models.*;

public class Application extends Controller {

    public static void index() {
        Plat plat = Plat.find("order by id desc").first();
        List<TypeReglement> typeReglements = TypeReglement.find("").fetch(4);
        List<Plat> platList = Plat.find("order by id desc").fetch(4);

        render(plat,platList, typeReglements);

    }

    public static void cart(Long idClient){

        //ce qu'on doit mettre
       // Com_Cli_Plat com_cli_plat = Com_Cli_Plat.findById(idClient);

        //pour le test de disposition
        Com_Cli_Plat com_cli_plat1 = Com_Cli_Plat.findById(new Long(1));
        render(com_cli_plat1);
    }

    public static void test(){
        List<Agent> agents = Agent.findAll();
        //redirect("Agent/list.html", agents);
        render();
    }

    public static void achatClient() {
        List<Plat> plats = Cache.get("plats", List.class);
        List<Long> quantites = (List<Long>) Cache.get("quantites");
        int i = 0;
        render(plats, quantites, i);
    }

    public static void panier() {
        List<Plat> plats = Cache.get("plats", List.class);
        List<Long> quantites = (List<Long>) Cache.get("quantites");
        int i = 0;
        render(plats, quantites, i);
    }

    public static void addToCart(long idPlat, long quantite) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Plat plats = Plat.findById(idPlat);
        if (plats != null) {
            if (Cache.get("plats") != null) {
                List<Plat> produits = Cache.get("plats", List.class);
                List<Long> quantites = (List<Long>) Cache.get("quantites");
                produits.add(plats);
                quantites.add(quantite);
                Cache.replace("plats", produits, "30min");
                Cache.replace("quantites", quantites, "30min");
            } else {
                List<Plat> platList = new ArrayList<Plat>();
                platList.add(plats);
                Cache.add("plats", platList, "30min");

                List<Long> quantites = new ArrayList<Long>();
                quantites.add(quantite);
                Cache.add("quantites", quantites, "30min");
            }
            hash(quantite, hashMap);
        }

        hashMap.put("error", true);
        renderJSON(hashMap);

    }

    private static void hash(long quantite, HashMap<String, Object> hashMap) {
        hashMap.put("error", false);
        hashMap.put("qte", quantite);
        hashMap.put("result", Cache.get("plats", List.class).toString());
        renderJSON(hashMap);
    }

    public static void savePlat() {
        List<Plat> plats = Cache.get("plats", List.class);
    }

    public static void caroussel(){
        Plat plat = Plat.find("order by id desc").first();
        List<Plat> platList = Plat.find("order by id desc").fetch(4);
        render(plat,platList);
    }

    public static void reglement(){
        List<TypeReglement> typeReglements = TypeReglement.find("").fetch(4);
        render(typeReglements);
    }



}