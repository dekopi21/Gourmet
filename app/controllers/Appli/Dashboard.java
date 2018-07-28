
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
package controllers.Appli;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import models.Produit;
import play.cache.Cache;
import play.mvc.Controller;

/**
 *
 * @author NIKABOU
 */
/*
public class Dashboards extends Controller {

    public static void index() {
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        render(categories, produits);
    }

    public static void pageCategorie() {
        List<models.Categorie> categories = models.Categorie.findAll();
        List<models.Produit> produits = models.Produit.findAll();
        render(categories, produits);
    }

    public static void compteClient() {
        render();
    }

    public static void achatClient() {
        List<Produit> produits = Cache.get("produits", List.class);
        List<Long> quantites = (List<Long>) Cache.get("quantites");
        int i = 0;
        render(produits, quantites, i);
    }

    public static void pageModeLiv() {
        render();
    }

    public static void pageModePaie() {
        render();
    }

    public static void pageConfirmCom() {
        render();
    }

    public static void pageFin() {
        render();
    }

    public static void panier() {
        List<Produit> produits = Cache.get("produits", List.class);
        List<Long> quantites = (List<Long>) Cache.get("quantites");
        int i = 0;
        render(produits, quantites, i);
    }

    public static void addToCart(long idProduit, long quantite) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        Produit produit = Produit.findById(idProduit);
        if (produit != null) {
            if (Cache.get("produits") != null) {
                List<Produit> produits = Cache.get("produits", List.class);
                List<Long> quantites = (List<Long>) Cache.get("quantites");
                produits.add(produit);
                quantites.add(quantite);
                Cache.replace("produits", produits, "30min");
                Cache.replace("quantites", quantites, "30min");
            } else {
                List<Produit> produits = new ArrayList<Produit>();
                produits.add(produit);
                Cache.add("produits", produits, "30min");

                List<Long> quantites = new ArrayList<Long>();
                quantites.add(quantite);
                Cache.add("quantites", quantites, "30min");
            }
            hashMap.put("error", false);
            hashMap.put("qte", quantite);
            hashMap.put("result", Cache.get("produits", List.class).toString());

            renderJSON(hashMap);
        }

        hashMap.put("error", true);
        renderJSON(hashMap);

    }

    public static void savePoduits() {
        List<Produit> produits = Cache.get("produits", List.class);
    }
}

*/