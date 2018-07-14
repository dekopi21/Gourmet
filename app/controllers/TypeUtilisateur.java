package controllers;

public enum TypeUtilisateur {
    ADMINSTRATEUR("/ADMINISTRATEUR"),
    AGENT("/AGENT"),
    CLIENT("/CLIENT"),
    LIVREUR("/LIVREUR"),
    RAS("");

    private String name;


    TypeUtilisateur(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
