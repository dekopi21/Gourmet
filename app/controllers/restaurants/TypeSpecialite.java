package controllers.restaurants;

public enum TypeSpecialite {
    AFRIQUE("Cuisine africaine"),
    EUROPE("Cuisine européen"),
    ASIA("Cuisine asiatique"),
    INDIANT("Cuisine indianne"),
    LIBANAIS("Cuisine libanaise");

    private String name;

    TypeSpecialite(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
