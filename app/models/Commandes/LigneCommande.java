package models.Commandes;

import models.restaurants.Menu;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;

@Entity
@Table(name = "lignecommande")
public class LigneCommande extends Model {

    @Required
    @ManyToOne
    private Menu menu;

    @Required
    @ManyToOne
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
