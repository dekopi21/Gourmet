package models.Commandes;


import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "facture")
public class Facture extends Model {
  /**
   *
   */
  @Required
  private double montant;
  /**
   *
   */
  @Required
  private boolean recu;

  public Facture(double montant, boolean recu) {
    this.montant = montant;
    this.recu = recu;
  }

  public Facture() {

  }

  public double getMontant() {
    return montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public boolean isRecu() {
    return recu;
  }

  public void setRecu(boolean recu) {
    this.recu = recu;
  }
}
