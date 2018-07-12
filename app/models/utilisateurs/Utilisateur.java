package models.utilisateurs;

import play.data.validation.Email;
import play.data.validation.MaxSize;
import play.data.validation.MinSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class Utilisateur extends Model {

  /**
   *
   */
  @Required
  @MinSize(6)
  @MaxSize(20)
  @Column(length = 20, nullable = true, unique = true)
  private String login;
  /**
   *
   */
  @Required
  @MinSize(8)
  @MaxSize(20)
  @Column(length = 20, nullable = true)
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

  public Utilisateur(String login, String password, String nomUtilisateur,
                     String prenomUtilisateur, String email, char sexe, String telephone,
                     String civilite, String ville, String quartier, String image) {


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
  }

  public Utilisateur(String login, String password, String email) {
    this.login = login;
    this.password = password;
    this.email = email;
  }

  public Utilisateur() {
  }

  public static Utilisateur connect(String email, String password) {
    return find("byEmailAndPassword", email, password).first();
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

  public static boolean isValidLogin(String username, String password) {
      return find("byEmailAndPassword", username, password).first();

  }
}
