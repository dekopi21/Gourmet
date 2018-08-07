package controllers.commandes;

import controllers.*;
import models.Commandes.TypeReglement;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.With;

import java.io.File;
import java.util.List;

import static play.test.FunctionalTest.renderArgs;

@With(Security.class)
@Check("Administrateur")
public class TypeReglements extends CRUD{
    //TODO afficher les msssages de flash

    public static void addTypeReglement(
            @Required(message = "Le champ libelle ne doit pas etre vide") String libelleTypeREng,
            @Required(message = "Logo non choisie")File logoTypeREng){
        if(Validation.hasErrors()){
renderHtml(logoTypeREng);
        }else
        try{
            new TypeReglement(libelleTypeREng, Actions.enregImage(logoTypeREng, TypeImage.TYPEREGLEMENT, TypeUtilisateur.RAS)).save();
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
            @Required(message = "Le champ libelle est vide") String libelleRModif,
            @Required(message = "")File logoTypeRModif){
        try{
            TypeReglement typeReglement  = TypeReglement.findById(idTypeRModif);
            typeReglement.setLibelle(libelleRModif);
            typeReglement.setLogo(Actions.enregImage(logoTypeRModif, TypeImage.TYPEREGLEMENT, TypeUtilisateur.RAS));
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
