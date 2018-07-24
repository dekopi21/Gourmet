package controllers.restaurants;

import controllers.CRUD;
import models.restaurants.DatePrix;
import models.restaurants.Plat;
import play.data.validation.Required;

import java.util.GregorianCalendar;
import java.util.List;

public class DatePrixs extends CRUD{
    public static void show(Long id){
        DatePrix datePrix = DatePrix.findById(id);
        render(datePrix);
    }

    public static void listDP(){
        List<DatePrix> datePrixes = DatePrix.findAll();
        render(datePrixes);
    }

    public static void dPrix(){
        List<Plat> plats = Plat.findAll();
        render();
    }

    public static void addDPrix(
            @Required(message = "")Long idPlat,
            @Required(message = "")double montantEngDP
    ){
        try {
            new DatePrix(Plat.<Plat>findById(idPlat),montantEngDP).save();
            flash.success("Enregistrement éffectué avec succes");
            redirect("controllers.restaurants.DatePrixs.listDP");
        }catch (Exception Ignore){
            flash.error("");
            redirect("crontrollers.restaurants.DatePrixs.dPrix");
        }
    }

    public static void suppDPrix(
            @Required(message = "") Long idSuppDp){
                try {
                    DatePrix  datePrix = DatePrix.findById(idSuppDp);
                    datePrix.delete();
                    flash.success("");
                    redirect("controllers.restaurants.DatePrixs.listDP");

                }catch (Exception Ignore){
                    flash.error("");
                    redirect("controllers.restaurants.DatePrixs.listDP");

                }
    }

    public static void modifDPrix(
            @Required(message = "")Long idModifDPrix,
            @Required(message = "")double montantModifDPrix,
            @Required(message = "")Long idPlatModif){
                try {
                    DatePrix datePrix = DatePrix.findById(idModifDPrix);
                    datePrix.setDateModification(new GregorianCalendar());
                    datePrix.setMontant(montantModifDPrix);
                    datePrix.setPlat(Plat.<Plat>findById(idPlatModif));
                    flash.success("");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }catch (Exception Ignore){
                    flash.error("");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }
    }
}
