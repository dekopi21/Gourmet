package controllers.commandes;

public enum  modeLivraison {
    DOMICILE("Le livraeur fait la livraison chez le client"),
    AUTRELIEU("Le livreur livre ailleurs"),
    RETRAITSURPLACE("Le client vient chercher");

    private String name;

    modeLivraison(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
