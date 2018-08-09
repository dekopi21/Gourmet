package controllers.portail;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import controllers.Security;
import models.restaurants.*;
import play.cache.Cache;
import play.mvc.With;

import javax.swing.plaf.DimensionUIResource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@With(Security.class)
@Check({"Agent", "Administrateur"})
public class Dashboards extends CRUD {

    public static void dashboard(){
        render();
    }

    public static void restaurant(){
       Restaurant restaurant =  Restaurant.find("").first();
        List<Categorie> categorie = Categorie.find("order by nom asc").fetch(6);
        render(restaurant,categorie);
    }

    public static final String durationCache = "30min";

    public static final String cleCachePanier = "cleCachePanier";

    public static boolean isCachedPanier()
    {
        return cachedPanier() != null;
    }

    public static HashMap<Object, Long> cachedPanier()
    {
        HashMap<Object, Long> cachedPanier = (HashMap<Object, Long>) Cache.get(cleCachePanier);

        return cachedPanier;
    }

    public static void ajouterPanier(long idPlat, long quantite)
    {
        HashMap<Object, Long> panier = new HashMap<Object, Long>();
        Plat plat = Plat.findById(idPlat);
        if (plat == null)
            renderJSON(false);

        if (isCachedPanier())
        {
            panier = cachedPanier();
            panier.remove(plat);
            panier.put(plat, quantite);
            Cache.safeReplace(cleCachePanier, panier, durationCache);
        }
        else
        {
            panier.put(plat, Long.valueOf(quantite));
            Cache.safeAdd(cleCachePanier, panier, durationCache);
        }
    }
    
    public static void addToCart(long idPlat, long quantite) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Plat plat = Plat.findById(idPlat);
        if (plat != null) {
            if (Cache.get("plat") != null) {
                List<Plat> plats = Cache.get("plat", List.class);
                List<Long> quantites = (List<Long>) Cache.get("quantites");
                plats.add(plat);
                quantites.add(quantite);
                Cache.replace("plat", plats, durationCache);
                Cache.replace("quantites", quantites, durationCache);
            } else {
                List<Plat> plats = new ArrayList<Plat>();
                plats.add(plat);
                Cache.add("plat", plats, durationCache);

                List<Long> quantites = new ArrayList<Long>();
                quantites.add(quantite);
                Cache.add("quantites", quantites, durationCache);
            }
            hashMap.put("error", false);
            hashMap.put("qte", quantite);
            hashMap.put("result", Cache.get("plat", List.class).toString());

            renderJSON(hashMap);
        }

        hashMap.put("error", true);
        renderJSON(hashMap);
    }

    /*
    public static void achatClient() {
        List<Plat> plats = Cache.get("plats", List.class);
        List<Long> quantites = (List<Long>) Cache.get("quantites");
        int i = 0;
        render(plats, quantites, i);
    }


    public static void savePlat() {
        List<Plat> produits = Cache.get("plat", List.class);
    }


    public static void AccueilPlat(){
        render();
    }

    public static void AccueilAgent(){
        List<Categorie> categories = Categorie.findAll();
        List<Plat> plats = Plat.find("order by id desc").fetch(5);
        List<Menu> menus = Menu.findAll();
        List<TypeMenu> typeMenus = TypeMenu.findAll();
        List<DatePrix> datePrixes = DatePrix.findAll();
        render(categories, plats, menus, typeMenus, datePrixes);
    }*/
}
