package models.restaurants;

import models.Commandes.Livreur;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "restaurant")
public class Restaurant extends Model {

  /**
   *
   */
  @Required
  @OneToMany(cascade = CascadeType.ALL)
  public List<Livreur> livreurs;
  /**
   *
   */
  @Required
  @MaxSize(30)
  private String nom;
  /**
   *
   */
  @Required
  @MaxSize(100)
  private String raisonSocial;
  /**
   *
   */
  @Required
  @MaxSize(50)
  private String localisation;
  /**
   *
   */
  @Required
  private String image;
  /**
   *
   */

  @Required
  private String specialite;


  @Required
  private String horaire;

  public Restaurant() {
  }

  public Restaurant(String nom, String raisonSocial,
                    String localisation, String image, String specialite, String horaire) {
    this.nom = nom;
    this.raisonSocial = raisonSocial;
    this.localisation = localisation;
    this.image = image;
    this.specialite = specialite;
    this.horaire = horaire;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getRaisonSocial() {
    return raisonSocial;
  }

  public String getSpecialite() {
    return specialite;
  }

  public void setSpecialite(String specialite) {
    this.specialite = specialite;
  }

  public String getHoraire() {
    return horaire;
  }

  public void setHoraire(String horaire) {
    this.horaire = horaire;
  }

  public void setRaisonSocial(String raisonSocial) {
    this.raisonSocial = raisonSocial;
  }

  public String getLocalisation() {
    return localisation;
  }

  public void setLocalisation(String localisation) {
    this.localisation = localisation;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public List<Livreur> getLivreurs() {
    return livreurs;
  }

  public void setLivreurs(List<Livreur> livreurs) {
    this.livreurs = livreurs;
  }
}
