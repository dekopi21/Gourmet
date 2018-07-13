package models.utilisateurs;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Administrateur extends Utilisateur {
  private Date dateConnexion;


  public Administrateur(Date dateConnexion) {
    this.dateConnexion = dateConnexion;
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
  public Administrateur(String login, String password, String
    nomUtilisateur, String prenomUtilisateur, String email,
                        char sexe, String telephone, String civilite, String ville, String quartier, String image, String profile) {
    super(login, password, nomUtilisateur, prenomUtilisateur, email, sexe, telephone, civilite, ville, quartier, image, profile);
    this.dateConnexion = new Date();
  }
}
