package models.Commandes;

import models.restaurants.Menu;
import play.data.validation.Required;
import play.db.jpa.Model;

public class LigneCommande extends Model {

  @Required
  private Menu menu;

  @Required
  private Commande commande;

  public LigneCommande() {
  }

  public LigneCommande(Menu menu, Commande commande) {
    this.menu = menu;
    this.commande = commande;
  }

  public Menu getMenu() {
    return menu;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
  }

  public Commande getCommande() {
    return commande;
  }

  public void setCommande(Commande commande) {
    this.commande = commande;
  }
}
