package models.restaurants;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "prix")
public class Prix extends Model {

  @Required
  private double montant;

  public Prix(double montant) {
    this.montant = montant;
  }

  public Prix() {
  }

  public double getMontant() {
    return montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }
}
