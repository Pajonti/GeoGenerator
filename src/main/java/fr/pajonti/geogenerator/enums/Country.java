package fr.pajonti.geogenerator.enums;

public enum Country {
    FRANCE("fr");

    public final String countryCode;

    Country(String countryCode){
        this.countryCode = countryCode;
    }
}
