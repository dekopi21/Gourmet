package models.Commandes;

import models.utilisateurs.Utilisateur;
import play.data.validation.Required;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "client")
public class Client extends Utilisateur {

  @Required
  @OneToMany(cascade = CascadeType.ALL)
  public List<Commande> commandes;

  public Client() {
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


  @SuppressWarnings("JavaDoc")
  public Client(String login, String password, String nomUtilisateur,
                String prenomUtilisateur, String email, char sexe, String telephone,
                String civilite, String ville, String quartier, String image, String profile) {
    super(login, password, nomUtilisateur,
      prenomUtilisateur, email, sexe, telephone, civilite, ville, quartier, image, profile);
    this.commandes = new ArrayList<Commande>();

  }

  /**
   * @param login
   * @param password
   * @param email
   */
  public Client(String login, String password, String email, String profile) {
    super(login, password, email, profile);
  }

  public Client addCommande(double prixComm, boolean valide, String etatComm) {
    Commande newCommande = new Commande(prixComm, valide, etatComm, this).save();
    return this;
  }

}
