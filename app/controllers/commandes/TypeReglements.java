package controllers.commandes;

import controllers.CRUD;
import models.Commandes.TypeReglement;
import play.data.validation.Required;

public class TypeReglements extends CRUD{

    public static void addTypeReglement(
            @Required(message = "Le champ libelle ne doit pas etre vide") String libelleTypeREng){
        try{
            new TypeReglement(libelleTypeREng).save();
            flash.success("Type règlement enregistré avec succes");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }catch (Exception e){
            flash.error("Type enregistrement existe déja");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }
    }

    public static void suppTypeR(Long idTypeR){
        try{
            TypeReglement typeReglement  = TypeReglement.findById(idTypeR);
            typeReglement.delete();
            flash.success("Suppression de Type reglement bien éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }catch (Exception e){
            flash.error("Suppression non éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }
    }
    public static void modiTypeR(
            @Required(message = "L'identifiant est introuvable") Long idTypeRModif,
            @Required(message = "Le champ libelle est vide") String libelleRModif){
        try{
            TypeReglement typeReglement  = TypeReglement.findById(idTypeRModif);
            typeReglement.setLibelle(libelleRModif);
            typeReglement.save();
            flash.success("Modification bien éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }catch (Exception e){
            flash.error("Modification non éffectué");
            redirect("controllers.utilisateurs.Administrateurs.crudAdmin");
        }
    }
}
