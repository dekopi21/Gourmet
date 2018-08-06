package controllers.commandes;

import controllers.CRUD;
import models.Commandes.Client;
import models.restaurants.Plat;
import play.cache.Cache;
import play.libs.Codec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Paniers extends CRUD {
    public static void monPanier(){
        render();
    }
    public static void compte(Long id){
        Client post = Client.findById(id);
        String randomID = Codec.UUID();
        render(post, randomID);
    }
    public static void modeLivraison(){
        render();
    }
    public static void recapitulatif(){
        render();
    }
    public static void modePaiement(){
        render();
    }


}
