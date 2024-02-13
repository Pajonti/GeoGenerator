package fr.pajonti.geogenerator.enums;

public enum Country {
    FRANCE("fr");

    private final String countryCode;

    Country(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }
}
