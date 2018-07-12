package models.Commandes;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "typereglement")
public class TypeReglement extends Model {
  /**
   *
   */
  @Required
  @MaxSize(30)
  private String libelle;

  @Required
  @OneToMany(cascade = CascadeType.ALL)
  private List<Reglement> reglements;

  public TypeReglement(String libelle) {
    this.libelle = libelle;
    this.reglements = new ArrayList<Reglement>();
  }

  public TypeReglement() {
  }


  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }
}
