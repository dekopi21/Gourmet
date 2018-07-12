package models.restaurants;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "typemenu")
public class TypeMenu extends Model {

  @Required
  @MaxSize(50)
  private String libelle;
  /**
   *
   */
  @Lob
  @Required
  @MaxSize(200)
  private String description;

  public TypeMenu() {
  }

  public TypeMenu(String libelle, String description) {
    this.libelle = libelle;
    this.description = description;
  }

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
