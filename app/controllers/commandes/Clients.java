package controllers.commandes;

import controllers.CRUD;
import controllers.Check;
import controllers.Secure;
import controllers.Security;
import controllers.restaurants.Agents;
import models.Commandes.Client;
import models.restaurants.Agent;
import models.utilisateurs.Utilisateur;
import play.cache.Cache;
import play.data.validation.Required;
import play.data.validation.Validation;
import play.mvc.With;

import java.util.HashMap;
import java.util.List;

import static org.h2.util.New.hashMap;

@With(Security.class)
public class Clients extends CRUD{
    public static void addClient()
    {

    }

//TODO demande la methode register chez fidèle
  public static void addClient( String nomEng,
                                String prenomEng,
                                String loginEng,
                                String passwordEng,
                                String TelephoneEng,
                                String VilleEng,
                                String QuartierEng,
                                String code,
                                String randomID) {
      validation.equals(
              code, Cache.get(randomID)
      ).message("Invalid code. Please type it again");
      if(Validation.hasErrors()) {
          return ;
      }else
      try {
      Client client = new Client(loginEng, Utilisateur.sethashpassword(passwordEng), nomEng, prenomEng, "",
              ' ', TelephoneEng, "", VilleEng, QuartierEng,"","Client").save();
      flash.success("Bienvenue %s", client.getNomUtilisateur());
          Cache.delete(randomID);
          return ;
    } catch (Exception e) {
      flash.error("échec", "Erreur d'enregistrement");
      return ;
    }
  }

  public static void index() {
      List<Utilisateur> utilisateurs = Utilisateur.findAll();
      render(utilisateurs);
  }


  @Check("Administrateur")
  public static void supprimerClient(Long id) {
    Client client = Client.findById(id);
    try {
      client.delete();
      index();
    } catch (Exception e) {
      Validation.addError("échec", "Erreur de suppression");
    }

  }


  @Check({"Agent","Administrateur"})
  public static void show(Long id) {
    Client client = Client.findById(id);
    render(client);
  }

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

public static void infoClient(Long identifiant){
  render();
}

}
