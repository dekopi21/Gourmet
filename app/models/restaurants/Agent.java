package models.restaurants;

import models.Commandes.Commande;
import models.Commandes.Livraison;
import models.utilisateurs.Utilisateur;
import play.data.validation.Required;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JavaDoc")
@Entity
public class Agent extends Utilisateur {

  @Required
  @OneToMany(cascade = CascadeType.ALL)
  public List<Livraison> livraisons;

  public Agent() {
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
  public Agent(String login, String password, String nomUtilisateur, String prenomUtilisateur, String email,
               char sexe, String telephone, String civilite, String ville, String quartier, String image, String profile) {
    super(login, password, nomUtilisateur, prenomUtilisateur,
      email, sexe, telephone, civilite, ville, quartier, image, profile);
    this.livraisons = new ArrayList<Livraison>();
  }

    public Agent(String login, String password, String email, String profile) {
        super(login, password, email, profile);
    }

    public Agent addLivraison(boolean livre, String adresseLivraison,
                            Commande commandes, Agent agent) {
        Livraison livraison = new Livraison(livre, adresseLivraison,
      commandes, this).save();
    return this;
  }
}
