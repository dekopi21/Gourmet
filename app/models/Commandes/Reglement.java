package models.Commandes;

import play.data.validation.Required;
import play.db.jpa.Model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "reglement")
public class Reglement extends Model {

    /**
     *
     */
    @Required
    private double montant;
    /**
     *
     */
    @Required
    private Date dateReglement;
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
    private TypeReglement typeReglement;

    public Reglement() {
    }

    public Reglement(double montant, TypeReglement typeReglement, Commande commande) {
        this.montant = montant;
        this.dateReglement = new Date();
        this.commande = commande;
        this.typeReglement = typeReglement;
    }


    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateReglement() {
        return dateReglement;
    }

    public void setDateReglement(Date dateReglement) {
        this.dateReglement = dateReglement;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public TypeReglement getTypeReglement() {
        return typeReglement;
    }

    public void setTypeReglement(TypeReglement typeReglement) {
        this.typeReglement = typeReglement;
    }
}
