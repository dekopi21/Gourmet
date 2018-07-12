package models.Commandes;

import models.restaurants.Restaurant;
import models.utilisateurs.Utilisateur;
import play.data.validation.Required;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ALL")
@Entity
public class Livreur extends Utilisateur {

  @Required
  @ManyToOne
  public Restaurant restaurant;

  @Required
  @OneToMany(cascade = CascadeType.ALL)
  public List<Livraison> livraisons;

  public Livreur() {

  }

  /**
   * @param login
   * @param password
   * @param nomUtilisateur
   * @param prenomUtilisateur
   * @param email
   * @param sexe
   * @param telephone
   * @param civilite
   * @param image
   */
  public Livreur(String login, String password, String nomUtilisateur,
                 String prenomUtilisateur, String email, char sexe, String telephone, String civilite, String ville, String quartier, String image, Restaurant restaurant) {
    super(login, password,
      nomUtilisateur, prenomUtilisateur, email,
      sexe, telephone, civilite, ville, quartier, image);
    this.livraisons = new ArrayList<Livraison>();
    this.restaurant = restaurant;
  }


    public Livreur(String login, String password, String email) {
        super(login, password, email);
    }

  public Restaurant getRestaurant() {
    return restaurant;
  }

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public List<Livraison> getLivraisons() {
    return livraisons;
  }

  public void setLivraisons(List<Livraison> livraisons) {
    this.livraisons = livraisons;
  }

  public Livreur addLivraison(boolean livre, String adresseLivraison, Facture facture, Commande commande) {
    Livraison livraison = new Livraison(livre, adresseLivraison, facture, commande, this).save();
    return this;
  }

}
