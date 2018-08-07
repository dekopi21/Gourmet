package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.Commandes.Livraison;
import models.Commandes.Livreur;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
@Check({"Agent","Livreur","Administrateur"})
public class Livraisons extends CRUD{
    public static void AccueilLivraison(){

        List<Livraison> livraisonsL = Livraison.find("livre =?1",true).fetch();
        List<Livraison> livraisonsN = Livraison.find("livre =?1",false).fetch();
        List<Livreur> livreurs = Livreur.findAll();
        render(livraisonsL, livraisonsN, livreurs);
    }

    public static void livraisonEffectuee(){
        render();
    }

    public static void livraisonNonEffectuee(){
        render();
    }

    public static void AgentLivre(){
        render();
    }

    public static void LivreurLivre(){
        render();
    }
}
