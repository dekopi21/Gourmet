package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Security;
import models.Commandes.Client;
import models.Commandes.Commande;
import models.Commandes.TypeReglement;
import play.cache.Cache;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.libs.Images;
import play.mvc.With;

import javax.persistence.PersistenceException;
import java.util.List;

import static play.data.validation.Validation.hasErrors;

@With(Security.class)
public class Commandes extends CRUD{
//TODO
  public static void ajouterCommande(
          @Required(message = "Oopps le champ Prix ne doit pas etre vide!!!")double prixCommEng,
          @Required(message = "Oopps le champ Etat ne doit pas etre vide!!!") String etatCommEng,
          @Required(message = "Oopps le champ client ne doit pas etre vide!!!") Long clientEng) {


    if (hasErrors()) {
      redirect("portail.Dashboards.AccueilAgent");
    }else
    try {
      Client client = Client.findById(clientEng);
      Commande commande = new Commande(prixCommEng,false,etatCommEng, client);
      flash.success("La comande de %s",client.getNomUtilisateur()+"\ta été prise en compte");
      //redirect("portail.Dashboards.AccueilAgent");

    } catch (Exception e) {
      Validation.addError("échec", "Erreur d'enregistrement");
      flash.error("");
     // redirect("portail.Dashboards.AccueilAgent");

    }
  }

  public static void index() {
    List<Commande> clients = Commande.findAll();
    render(clients);
  }


  public static void supprimerClient(Long id) {
    Commande client = Commande.findById(id);
    try {
      client.delete();
      index();
    } catch (Exception e) {
      Validation.addError("échec", "Erreur de suppression");
    }

  }

  /**
   * permet de reccuper l'id du client et faire la modification
   *
   * @param id
   */
  public static void show(Long id) {
    Commande client = Commande.findById(id);
    render(client);
  }

  public static void modifierClient(Long id, Commande commande) {
    Commande commande1 = Commande.findById(id);
    commande1 = commande;
    commande.save();
    show(id);
  }

  @Check("Agent")
  public static void validerCommande(Long id){
    try {
      Commande commande = Commande.findById(id);
      commande.setValide(true);
      commande.save();
      redirect("commandes.Commandes.AccueilCommande");
    }catch (PersistenceException e){
      e.getCause();
    }

  }

  @Check({"Agent", "Administrateur"})
  public static void etatCommande(){
    render();
  }

  @Check({"Agent", "Administrateur"})
  public static void etatCommande(Long id){
    try {
      Commande commande = Commande.findById(id);
      commande.setEtatComm("Prette");
      commande.save();
    }catch (PersistenceException e){
      e.getCause();
    }
  }

  public static void commande() {
    render();
  }

  @Check({"Agent","Livreur", "Administrateur"})
  public static void CommandeLivree(){
    List<Commande> commande = Commande.find("valide =?1",0).fetch();
    render(commande);
  }
  public static void historiqueCommandeRegeter(){
    List<Commande> commandes = Commande.find("valide =?1",1).fetch();
    render(commandes);
  }
  @Check("Client")
  public static void client(){
    List<TypeReglement> typeReglement = TypeReglement.find("order by id desc").fetch(5);
    render(typeReglement);
  }

  public static void saveCommandeClient(){
  }
  public static void captcha(String id) {
    Images.Captcha captcha = Images.captcha();
    String code = captcha.getText("#FF2A7F");
    Cache.set(id, code, "10mn");
    renderBinary(captcha);
  }

  @Check({"Agent", "Administrateur"})
  public static void AccueilCommande(){
    List<Commande> commande = Commande.find("valide =?1",true).fetch();
    List<Commande> commandeN = Commande.find("valide =?1",false).fetch();
    List<Commande> commandeNE = Commande.findAll();
    render(commande,commandeN, commandeNE);
  }
}


