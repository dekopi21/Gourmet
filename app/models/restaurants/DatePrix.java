package models.restaurants;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "dateprix")
public class DatePrix extends Model {
  /**
   *
   */
  @Required
  private Date dateModification;
  /**
   *
   */
  @Required
  private Prix prix;
  /**
   *
   */
  @Required
  private Plat plat;

  public DatePrix(Prix prix, Plat plat) {

    this.dateModification = new Date();
    this.prix = prix;
    this.plat = plat;
  }

  public DatePrix(Date dateModification) {
    this.dateModification = dateModification;
  }

  public Prix getPrix() {
    return prix;
  }

  public void setPrix(Prix prix) {
    this.prix = prix;
  }

  public Plat getPlat() {
    return plat;
  }

  public void setPlat(Plat plat) {
    this.plat = plat;
  }

  public Date getDateModification() {
    return dateModification;
  }

  public void setDateModification(Date dateModification) {
    this.dateModification = dateModification;
  }
}
