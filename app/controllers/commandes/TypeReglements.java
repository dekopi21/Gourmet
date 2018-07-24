package controllers.commandes;

import controllers.CRUD;
import models.Commandes.TypeReglement;
import play.data.validation.Required;

import java.util.List;

public class TypeReglements extends CRUD{

    public static void addTypeReglement(
            @Required(message = "Le champ libelle ne doit pas etre vide") String libelleTypeREng){
        try{
            new TypeReglement(libelleTypeREng).save();
            flash.success("Type règlement enregistré avec succes");
            redirect("controllers.commandes.TypeReglements.listTypeR");
        }catch (Exception e){
            flash.error("Type enregistrement existe déja");
            redirect("controllers.commandes.TypeReglements.typeR");
        }
    }

    public static void suppTypeR(Long idTypeR){
        try{
            TypeReglement typeReglement  = TypeReglement.findById(idTypeR);
            typeReglement.delete();
            flash.success("Suppression de Type reglement bien éffectué");
            redirect("controllers.commandes.TypeReglements.listTypeR");
        }catch (Exception e){
            flash.error("Suppression non éffectué");
            redirect("controllers.commandes.TypeReglements.listTypeR");
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
            redirect("controllers.commandes.TypeReglements.listTypeR");
        }catch (Exception e){
            flash.error("Modification non éffectué");
            redirect("controllers.commandes.TypeReglements.listTypeR");

        }
    }


    public static void show(Long idTypeR){
        TypeReglement typeReglement = TypeReglement.findById(idTypeR);
        render(typeReglement);
    }

    public static void listTypeR(){
        List<TypeReglement> typeReglementList = TypeReglement.findAll();
        render(typeReglementList);
    }

    public static void typeR(){
        render();
    }
}
