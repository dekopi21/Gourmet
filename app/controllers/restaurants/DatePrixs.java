package controllers.restaurants;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.restaurants.DatePrix;
import models.restaurants.Plat;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.With;

import java.util.GregorianCalendar;
import java.util.List;

@With(Secure.class)
@Check("Agent")
public class DatePrixs extends CRUD{


    public static void show(Long id){
        DatePrix datePrix = DatePrix.findById(id);
        render(datePrix);
    }

    @Check("Agent")
    public static void listDP(){
        List<DatePrix> datePrixes = DatePrix.findAll();
        render(datePrixes);
    }

    @Check("Agent")
    public static void dPrix(){
        List<Plat> plats = Plat.findAll();
        render(plats);
    }

    @Check("Agent")
    public static void addDPrix(
            @Required(message = "")Long idPlat,
            @Required(message = "")double montantEngDP
    ){
        if(Validation.hasErrors()){

        }else
        try {
            new DatePrix(Plat.<Plat>findById(idPlat),montantEngDP).save();
            flash.success("Enregistrement éffectué avec succes");
            redirect("controllers.restaurants.DatePrixs.listDP");
        }catch (Exception Ignore){
            flash.error("Enregistrement echoué cette enregistrement exist déja");
            redirect("crontrollers.restaurants.DatePrixs.dPrix");
        }
    }

    @Check("Agent")
    public static void suppDPrix(
            @Required(message = "") Long idSuppDp){
                if(Validation.hasErrors()){
                    error("l'idendifiant de l'enregistrement est introuvable");
                }else
                try {
                    DatePrix  datePrix = DatePrix.findById(idSuppDp);
                    datePrix.delete();
                    flash.success("Suppression de l'enregistrement éffectué");
                    redirect("controllers.restaurants.DatePrixs.listDP");

                }catch (Exception Ignore){
                    flash.error("Suppression échoué");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }
    }

    @Check("Agent")
    public static void modifDPrix(
            @Required(message = "")Long idModifDPrix,
            @Required(message = "")double montantModifDPrix){
                if(Validation.hasErrors()){
                    error("Veillez saisir correctement les champs");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }else
                try {
                    DatePrix datePrix = DatePrix.findById(idModifDPrix);
                    datePrix.setDateModification(new GregorianCalendar());
                    datePrix.setMontant(montantModifDPrix);
                    datePrix.save();
                    flash.success("Modification bien éffectué");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }catch (Exception Ignore){
                    flash.error("Modification echoué");
                    redirect("controllers.restaurants.DatePrixs.listDP");
                }
    }
}
