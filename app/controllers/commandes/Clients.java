package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import models.Commandes.Client;
import models.utilisateurs.Utilisateur;
import play.data.validation.Validation;
import play.mvc.With;

import java.util.List;

@With(Secure.class)
@Check("Client")
public class Clients extends CRUD{

  public static void addClient( String password, String EmailClient, String TelephoneClient, String VilleClient, String QuartierClient) {
    try {
      Client client = new Client("", password, "", "", EmailClient,
              ' ', TelephoneClient, "", VilleClient, QuartierClient,"","Client").save();

      flash.success("Bienvenue %s", client.getNomUtilisateur());

    } catch (Exception e) {
      flash.error("échec", "Erreur d'enregistrement");
      redirect("client.show");
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

public static void menuPlats(){
  render();
}

}
