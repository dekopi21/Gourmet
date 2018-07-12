package models.Commandes;

import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "commande")
public class Commande extends Model {

  /**
   *
   */
  @Required
  private Date dateComm;
  /**
   *
   */
  @Required
  private double prixComm;
  /**
   *
   */
  @Required
  private boolean valide;
  /**
   *
   */
  @Required
  @MaxSize(30)
  private String etatComm;

  public Commande(double prixComm, boolean valide, String etatComm, Client client) {
    this.dateComm = new Date();
    this.prixComm = prixComm;
    this.valide = valide;
    this.etatComm = etatComm;
    /*

     */
    Client client1 = client;
    List<Livraison> livraisons = new ArrayList<Livraison>();
  }

  public Commande() {
  }


  public Date getDateComm() {
    return dateComm;
  }

  public void setDateComm(Date dateComm) {
    this.dateComm = dateComm;
  }

  public double getPrixComm() {
    return prixComm;
  }

  public void setPrixComm(double prixComm) {
    this.prixComm = prixComm;
  }

  public boolean isValide() {
    return valide;
  }

  public void setValide(boolean valide) {
    this.valide = valide;
  }

  public String getEtatComm() {
    return etatComm;
  }

  public void setEtatComm(String etatComm) {
    this.etatComm = etatComm;
  }
}
