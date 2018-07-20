package controllers;

import models.utilisateurs.Utilisateur;
import play.libs.Codec;

public class Security extends Secure.Security {

    static boolean authenticate(String username, String password) {
     return Utilisateur.isValidLogin(username, password)  ;
    }

    public static String setHashPassword(String password){
        return Codec.hexSHA1(password);
    }

 
  static void onAuthenticated(){
    String utilisateur = getUser().getProfile();
    if ("Agent".equals(utilisateur)){
      System.out.println("Agent");
      controllers.utilisateurs.Utilisateurs.crudAgent();
    }else if("Livreur".equals(utilisateur)){
      System.out.println("Livreur");
      controllers.commandes.Clients.client();
    }
  }
    static boolean check(String profile) {
        if ("Agent".equals(profile) || "Livreur".equals(profile) || "Client".equals(profile) || "Administrateur".equals(profile)) {
            return Boolean.parseBoolean(Utilisateur.find("byLogin", connected()).<Utilisateur>first().getProfile());
        }
        return false;
    }



    private static Utilisateur getUser() {
        Utilisateur user = Utilisateur.find("byLogin", Security.connected()).first();
        return user;
    }

    private static void logout(){
        Security.logout();
    }

}
