package models;

import models.Commandes.Client;
import models.Commandes.Commande;
import models.restaurants.Plat;

import javax.persistence.*;

@Entity
@Table(name = "com_cli_plat")
public class Com_Cli_Plat {

    @Id
    private Long idCCP;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Id_Commade")
    private Commande commandes;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name = "Id_CLient")
    private Client client;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "Id_Plat")
    private Plat plat;

    public Com_Cli_Plat(Commande commandes, Client client, Plat plat) {
        this.commandes = commandes;
        this.client = client;
        this.plat = plat;
    }

    public Com_Cli_Plat() {
    }

    public Commande getCommandes() {
        return commandes;
    }

    public void setCommandes(Commande commandes) {
        this.commandes = commandes;
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

}
