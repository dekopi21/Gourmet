package models.restaurants;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorie")
public class Categorie extends Model {
  /**
   *
   */
  @Required
  @MaxSize(20)
  private String nom;
  /**
   *
   */
  @Required
  @Lob
  @MaxSize(200)
  private String description;

  /**
   *
   */
  @Required
  @SuppressWarnings("FieldCanBeLocal")
  @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
  private List<Plat> plats;

  public Categorie() {
  }

  public Categorie(String nom, String description) {
    this.nom = nom;
    this.description = description;
    this.plats = new ArrayList<Plat>();
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


}
