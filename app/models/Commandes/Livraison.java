package models.Commandes;

import models.restaurants.Agent;
import play.data.validation.MaxSize;
import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "livraison")
public class Livraison extends Model {

  /**
   *
   */
  @Required
  private Date dateLivraison;
  /**
   *
   */
  @Required
  private boolean livre;
  /**
   *
   */
  @Required
  @MaxSize(50)
  private String adresseLivraison;
  /**
   *
   */
  @Required
  @ManyToOne
  private Livreur livreur;
  /**
   *
   */
  @Required
  @ManyToOne
  private Commande commande;
  /**
   *
   */
  @Required
  @ManyToOne
  private Agent agent;

  public Livraison() {
  }

    public Livraison(boolean livre, String adresseLivraison,
                     Livreur livreur, Commande commandes) {
    this.dateLivraison = new Date();
    this.livre = livre;
    this.adresseLivraison = adresseLivraison;
    this.livreur = livreur;
    this.commande = commandes;
  }

    public Livraison(boolean livre, String adresseLivraison,
                     Commande commandes, Agent agent) {
    this.dateLivraison = new Date();
    this.livre = livre;
    this.adresseLivraison = adresseLivraison;
    this.commande = commandes;
    this.agent = agent;
  }

    public Livraison(boolean livre, String adresseLivraison,
                     Commande commandes, Livreur livreur) {
    this.dateLivraison = new Date();
    this.livre = livre;
    this.adresseLivraison = adresseLivraison;
    this.commande = commandes;
    this.livreur = livreur;
  }


  public Date getDateLivraison() {
    return dateLivraison;
  }

  public void setDateLivraison(Date dateLivraison) {
    this.dateLivraison = dateLivraison;
  }

  public boolean isLivre() {
    return livre;
  }

  public void setLivre(boolean livre) {
    this.livre = livre;
  }

  public String getAdresseLivraison() {
    return adresseLivraison;
  }

  public void setAdresseLivraison(String adresseLivraison) {
    this.adresseLivraison = adresseLivraison;
  }

  public Livreur getLivreur() {
    return livreur;
  }

  public void setLivreur(Livreur livreur) {
    this.livreur = livreur;
  }

  public Commande getCommandes() {
    return commande;
  }

  public void setCommandes(Commande commandes) {
    this.commande = commandes;
  }
}
