package fr.pajonti.geogenerator;

import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.reader.GeoJsonReader;

public class Runner {
    public static void main(String[] args){

        GeoJsonReader.readCountryFile(Country.FRANCE);

    }
}
