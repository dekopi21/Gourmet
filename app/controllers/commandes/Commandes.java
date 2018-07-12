package controllers.commandes;

import models.Commandes.Commande;
import play.data.validation.Validation;

import java.util.List;

public class Commandes {

  public static void ajouterCommande(double prixComm, boolean valide,
                                     String etatComm
  ) {
    try {
      Commande commande = new Commande();
      commande.setPrixComm(prixComm);
      commande.setEtatComm(etatComm);
      commande.setValide(valide);
      commande.save();
      flash("succes", "commande bien Enregistré");
    } catch (Exception e) {
      Validation.addError("échec", "Erreur d'enregistrement");
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

}
