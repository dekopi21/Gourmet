package models;

import models.Commandes.Client;
import models.Commandes.Commande;
import models.restaurants.Plat;
import play.db.jpa.Model;

import javax.persistence.*;

@Entity
@Table(name = "com_cli_plat")
public class Com_Cli_Plat extends Model{

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Id_Commade")
    private Commande commande;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "Id_CLient")
    private Client client;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Id_Plat")
    private Plat plat;

    public Com_Cli_Plat(Commande commande, Client client, Plat plat) {
        this.commande = commande;
        this.client = client;
        this.plat = plat;
    }

    public Com_Cli_Plat() {
    }

    public Commande getCommandes() {
        return commande;
    }

    public void setCommandes(Commande commandes) {
        this.commande = commandes;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Plat getPlat() {
        return plat;
    }

    public void setPlat(Plat plat) {
        this.plat = plat;
    }

    public String findNomByObject(Client client){
        return client.getNomUtilisateur();
    }

    public Long findNumCommandeByObject(Commande commande){
        return commande.getId();
    }

    public String findLibelleByObject(Plat plat){
        return plat.getNomPlat();
    }

}
