package models.restaurants;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.GregorianCalendar;

@Entity
@Table(name = "dateprix")
public class DatePrix extends Model {
  /**
   *
   */
  @Required
  private GregorianCalendar dateModification;

  /**
   *
   */
  @Required
  @ManyToOne
  private Plat plat;

  @Required
  private double montant;

  public DatePrix(Plat plat, double montant) {
    this.dateModification = new GregorianCalendar();
    this.plat = plat;
    this.montant = montant;
  }

  public DatePrix() {
  }

  public double getMontant() {

    return montant;
  }

  public void setMontant(double montant) {
    this.montant = montant;
  }

  public DatePrix(GregorianCalendar dateModification) {
    this.dateModification = dateModification;
  }

  public Plat getPlat() {
    return plat;
  }

  public void setPlat(Plat plat) {
    this.plat = plat;
  }

  public GregorianCalendar getDateModification() {
    return dateModification;
  }

  public void setDateModification(GregorianCalendar dateModification) {
    this.dateModification = dateModification;
  }

  public String findPlatByObject(Plat plat){
    return plat.getNomPlat();
  }

  public String  findImageByObject(Plat plat){
    return plat.getImage();
  }


}
