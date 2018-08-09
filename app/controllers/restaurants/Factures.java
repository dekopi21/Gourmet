package controllers.restaurants;

import controllers.CRUD;
import controllers.Check;
import controllers.Security;
import models.Com_Cli_Plat;
import play.mvc.With;

import java.util.List;

@With(Security.class)
@Check({"Agent", "Administrateur"})
public class Factures extends CRUD {
    public static void facture(){
        List<Com_Cli_Plat> com_cli_plat = Com_Cli_Plat.findAll();
        render(com_cli_plat);
    }

    public static void AccueilFacture(){
        List<Com_Cli_Plat> com_cli_plat = Com_Cli_Plat.findAll();

        render(com_cli_plat);
    }
}
