package models.restaurants;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "plat")
public class Plat extends Model {
  /**
   *
   */
  @Required
  @MaxSize(30)
  private String nomPlat;
  /**
   *
   */
  @Required
  private String image;
  /**
   *
   */
  @Lob
  @Required
  @MaxSize(200)
  private String description;
  /**
   *
   */
  @Required
  private boolean disponible;
  /**
   *
   */
  @Required
  @ManyToOne
  private Categorie categorie;

  /**
   *
   */


  public Plat(String nomPlat, String image, String description, boolean disponible,
              Categorie categorie) {
    this.nomPlat = nomPlat;
    this.image = image;
    this.description = description;
    this.disponible = disponible;
    this.categorie = categorie;

  }

  public Plat() {
  }

  public String getNomPlat() {
    return nomPlat;
  }

  public void setNomPlat(String nomPlat) {
    this.nomPlat = nomPlat;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isDisponible() {
    return disponible;
  }

  public void setDisponible(boolean disponible) {
    this.disponible = disponible;
  }

  public Categorie getCategorie() {
    return categorie;
  }

  public void setCategorie(Categorie categorie) {
    this.categorie = categorie;
  }

}
