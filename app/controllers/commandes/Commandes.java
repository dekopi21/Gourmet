package controllers.commandes;

import controllers.CRUD;
import models.Commandes.Client;
import models.Commandes.Commande;
import models.Commandes.TypeReglement;
import play.cache.Cache;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.libs.Images;

import java.util.List;

import static play.data.validation.Validation.hasErrors;

public class Commandes extends CRUD{

  public static void ajouterCommande(
          @Required(message = "Oopps le champ Prix ne doit pas etre vide!!!")double prixCommEng,
          @Required(message = "Oopps le champ Etat ne doit pas etre vide!!!") String etatCommEng,
          @Required(message = "Oopps le champ client ne doit pas etre vide!!!") Long clientEng) {


    if (hasErrors()) {
      render("/restaurants/Categories/listCat.html");
    }else
    try {
      Client client = Client.findById(clientEng);
      Commande commande = new Commande(prixCommEng,false,etatCommEng, client);
      flash.success("La comande de %s",client.getNomUtilisateur()+"\ta été prise en compte");
      redirect("Categories/listCat.html");
    } catch (Exception e) {
      Validation.addError("échec", "Erreur d'enregistrement");
      redirect("Categories/listCat.html");

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

  public static void commande() {
    render();
  }

  public static void historiqueCommandeLivree(){
    List<Commande> commande = Commande.find("where livre =0").fetch();
    render(commande);
  }
  public static void historiqueCommandeRegeter(){
    List<Commande> commandes = Commande.find("where livre =1").fetch();
    render(commandes);
  }

  public static void client(){
    List<TypeReglement> typeReglement = TypeReglement.findAll();
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
}


