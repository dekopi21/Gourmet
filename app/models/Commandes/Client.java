package models.Commandes;


import models.Com_Cli_Plat;
import models.utilisateurs.Utilisateur;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
//@Table(name = "client")
public class Client extends Utilisateur {

  @OneToMany
  private List<Com_Cli_Plat> com_cli_plat;
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
  }

  /**
   * @param login
   * @param password
   * @param email
   */
  public Client(String login, String password, String email, String profile) {
    super(login, password, email, profile);
  }
/*
    public Set<Cocliplat> getCocliplat() {
        return cocliplat;
    }

    public void setCocliplat(Set<Cocliplat> cocliplat) {
        this.cocliplat = cocliplat;
    }
*/
    public Client findClientbyNom(String nom){
      return Utilisateur.find("byNomUtilisateur",nom).first();
  }
}
