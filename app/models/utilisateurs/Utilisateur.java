package models.utilisateurs;

import controllers.Application;
import controllers.Security;
import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;
import play.libs.Codec;

import javax.persistence.*;

import static play.mvc.Controller.redirect;

@Entity
public class Utilisateur extends Model {

  /**
   *
   */
  @Required
  @MinSize(6)
  @MaxSize(20)
  @Column(length = 25, nullable = true, unique = true)
  private String login;
  /**
   *
   */
  @Required
  @MinSize(6)
  @Column(nullable = true)
  private String password;
  /**
   *
   */
  @Required
  @MinSize(5)
  @MaxSize(12)
  @Column(length = 20)
  private String nomUtilisateur;
  /**
   *
   */
  @MaxSize(25)
  @Column(length = 50)
  private String prenomUtilisateur;
  /**
   *
   */
  @Required
  @Email
  @MaxSize(20)
  @Column(length = 30)
  private String email;
  /**
   *
   */
  @Required
  @MaxSize(1)
  private char sexe;
  /**
   *
   */
  @Required
  private String telephone;
  /**
   *
   */
  @Required
  @Lob
  @MaxSize(20)
  @Column(length = 50)
  private String civilite;
  /**
   *
   */
  @Required
  @MaxSize(12)
  @Column(length = 30)
  private String ville;
  /**
   *
   */
  @Required
  @MaxSize(15)
  @Column(length = 30)
  private String quartier;
  /**
   *
   */
  @Required
  @Column(length = 60)
  private String image;

  /**
   *
   */
  @Required
  @Column(length = 60)
  private String profile;

  public Utilisateur(String login, String password, String nomUtilisateur, String prenomUtilisateur, String email, char sexe, String telephone, String civilite, String ville,
                     String quartier, String image, String profile) {
    this.login = login;
    this.password = password;
    this.nomUtilisateur = nomUtilisateur;
    this.prenomUtilisateur = prenomUtilisateur;
    this.email = email;
    this.sexe = sexe;
    this.telephone = telephone;
    this.civilite = civilite;
    this.ville = ville;
    this.quartier = quartier;
    this.image = image;
    this.profile = profile;
  }

  public Utilisateur(String login, String password, String email, String profile) {
    this.login = login;
    this.password = password;
    this.email = email;
    this.profile = profile;
  }

  /**
   *
   */




  public Utilisateur() {
  }



  public static String sethashpassword(String password){
    return Codec.hexSHA1(password);
  }

  public static boolean isValidLogin(String login , String password){
    System.err.println("***** Password :"+sethashpassword(password));
    System.err.println(count("login=?1 AND password=?2", login, password));
    return (count("login=?1 AND password=?2", login, sethashpassword(password)) == 1);
  }



  static void onDisconnected() {
    Application.index();
  }
  //TODO verifier si la methode creer dans le modèle a sa place

  /*
  static void onAuthenticated(String utilisateur) {
    if ("Agent".equals(utilisateur))

    Utilisateur.index();
  }

*/
  public static boolean isValidPwdById(Long id, String password){
    return (count("id=?1 AND password=?2", id, sethashpassword(password)) ==1);
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNomUtilisateur() {
    return nomUtilisateur;
  }

  public String getVille() {
    return ville;
  }

  public void setVille(String ville) {
    this.ville = ville;
  }

  public String getQuartier() {
    return quartier;
  }

  public void setQuartier(String quartier) {
    this.quartier = quartier;
  }

  public void setNomUtilisateur(String nomUtilisateur) {
    this.nomUtilisateur = nomUtilisateur;
  }

  public String getPrenomUtilisateur() {
    return prenomUtilisateur;
  }

  public void setPrenomUtilisateur(String prenomUtilisateur) {
    this.prenomUtilisateur = prenomUtilisateur;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public char getSexe() {
    return sexe;
  }

  public void setSexe(char sexe) {
    this.sexe = sexe;
  }

  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public String getCivilite() {
    return civilite;
  }

  public void setCivilite(String civilite) {
    this.civilite = civilite;
  }


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }




  public String getProfile() {
    return profile;
  }

  public void setProfile(String profile) {
    this.profile = profile;
  }

  public static void index() {
  }

}
