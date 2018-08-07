package controllers.portail.partenaire;

import controllers.CRUD;
import models.Commandes.Commande;

import java.util.List;

public class Dashboards extends CRUD {
    public static void dashboard(){
        List<Commande> commandes = Commande.findAll();
        render(commandes);
    }
}
