package fr.pajonti.geogenerator;

import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.helpers.MapperHelper;
import fr.pajonti.geogenerator.model.GeoCity;
import fr.pajonti.geogenerator.reader.GeoJsonReader;
import org.json.JSONObject;

import java.util.List;

public class Runner {
    public static void main(String[] args){

        String s = GeoJsonReader.readCountryFile(Country.FRANCE);
        List<GeoCity> geoCities = MapperHelper.getCountryMapperByCountry(Country.FRANCE).mapStringToGeoCityList(s);
    }
}
