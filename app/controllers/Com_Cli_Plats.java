package controllers;

import models.Com_Cli_Plat;
import models.Commandes.Client;
import models.Commandes.Commande;
import models.restaurants.Plat;
import play.data.validation.Required;
import play.data.validation.Validation;

import java.util.List;

public class Com_Cli_Plats extends CRUD {

    public static void listCCP(){
        List<Com_Cli_Plat> com_cli_plats = Com_Cli_Plat.find("order by id desc").fetch(4);
        render(com_cli_plats);
    }

    public static void show(Long idCCP){
        render(Com_Cli_Plat.findById(idCCP));
    }

    public static void addCCP(
            @Required(message = "")Long idCom,
            @Required(message = "")Long idCli,
            @Required(message = "")Long idPlat){
        if(Validation.hasErrors()){

        }else
            try {
                Commande commande = Commande.findById(idCom);
                Client client = Client.findById(idCli);
                Plat plat = Plat.findById(idPlat);
            new Com_Cli_Plat(commande, client, plat).save();
            flash.success("");
            redirect("");
            }catch (Exception Ignore){
            flash.error("");
            redirect("");
            }

            //TODO checher comment faire fonctionner cette methode d'ajoute dans la table
    }
}
