package controllers.commandes;

import models.Commandes.Client;
import models.utilisateurs.Utilisateur;
import play.data.validation.Validation;

import java.util.List;

public class Clients {

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
  public static void ajouterClient(String login, String password, String nomUtilisateur,
                                   String prenomUtilisateur, String email, char sexe, String telephone,
                                   String civilite, String ville, String quartier, String image) {
    try {
      Client client = new Client();
      client.setVille(ville);
      client.setQuartier(quartier);
      client.setCivilite(civilite);
      client.setEmail(email);
      client.setLogin(login);
      client.setImage(image);
      client.setNomUtilisateur(nomUtilisateur);
      client.setPassword(password);
      client.setPrenomUtilisateur(prenomUtilisateur);
      client.setSexe(sexe);
      client.setTelephone(telephone);
      client.save();

      flash.success("Bienvenue %s", client.getNomUtilisateur());

    } catch (Exception e) {
      Validation.addError("échec", "Erreur d'enregistrement");
      render("client/show.html");
    }
  }

  public static void index() {
      List<Utilisateur> utilisateurs = Utilisateur.findAll();
      render(utilisateurs);
  }


  /**
   * permet  de supprimer un client en utilisant son id
   *
   * @param id
   */

  public static void supprimerClient(Long id) {
    Client client = Client.findById(id);
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
   * @return rien
   */
  public static void show(Long id) {
    Client client = Client.findById(id);
    render(client);
  }

  /**
   * permet d'enregister la modification
   *
   * @param client
   */
  public static void modifierClient(Long id, Client client) {
      Client client1 = Client.findById(id);
      client1 = client;
      client1.save();
      show(id);
  }

  public static void client() {
    render();
  }


}
