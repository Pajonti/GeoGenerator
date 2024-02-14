package fr.pajonti.geogenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.helpers.MapperHelper;
import fr.pajonti.geogenerator.model.GeoCity;
import fr.pajonti.geogenerator.reader.GeoJsonReader;
import fr.pajonti.geogenerator.writers.GeoJSONWriter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void main(String[] args) throws IOException {

        for(GeoCity city : getGeoCities()){
                logger.info("Reading city : " + city.getCountry() + "-" + city.getPostcode() + " : " + city.getName() + " with " + city.getCoordinates().size() + " polygons.");
                ObjectMapper mapper = new ObjectMapper();

                GeoJSONWriter.writeToFile(
                        "C:\\Users\\Pierre-Yves\\Desktop\\100 locations in chef lieux\\geojsons",
                        city.getPostcode().substring(0, city.getPostcode().startsWith("97") ? 3 : 2) + "-" + city.getName() + ".geojson",
                        mapper.writeValueAsString(city));

        }

    }

    public static List<GeoCity> getGeoCities(){
        String s = GeoJsonReader.readCountryFile(Country.FRANCE);
        List<GeoCity> geoCities = MapperHelper.getCountryMapperByCountry(Country.FRANCE).mapStringToGeoCityList(s);

        List<GeoCity> selected = new LinkedList<>();

        for(GeoCity city : geoCities){
            if(city.getPostcode().startsWith("01") && city.getName().equalsIgnoreCase("Bourg-en-Bresse")){selected.add(city);}
            if(city.getPostcode().startsWith("02") && city.getName().equalsIgnoreCase("Laon")){selected.add(city);}
            if(city.getPostcode().startsWith("03") && city.getName().equalsIgnoreCase("Moulins")){selected.add(city);}
            if(city.getPostcode().startsWith("04") && city.getName().equalsIgnoreCase("Digne-les-Bains")){selected.add(city);}
            if(city.getPostcode().startsWith("05") && city.getName().equalsIgnoreCase("Gap")){selected.add(city);}
            if(city.getPostcode().startsWith("06") && city.getName().equalsIgnoreCase("Nice")){selected.add(city);}
            if(city.getPostcode().startsWith("07") && city.getName().equalsIgnoreCase("Privas")){selected.add(city);}
            if(city.getPostcode().startsWith("08") && city.getName().equalsIgnoreCase("Charleville-Mézières")){selected.add(city);}
            if(city.getPostcode().startsWith("09") && city.getName().equalsIgnoreCase("Foix")){selected.add(city);}
            if(city.getPostcode().startsWith("10") && city.getName().equalsIgnoreCase("Troyes")){selected.add(city);}
            if(city.getPostcode().startsWith("11") && city.getName().equalsIgnoreCase("Carcassonne")){selected.add(city);}
            if(city.getPostcode().startsWith("12") && city.getName().equalsIgnoreCase("Rodez")){selected.add(city);}
            if(city.getPostcode().startsWith("13") && city.getName().equalsIgnoreCase("Marseille")){selected.add(city);}
            if(city.getPostcode().startsWith("14") && city.getName().equalsIgnoreCase("Caen")){selected.add(city);}
            if(city.getPostcode().startsWith("15") && city.getName().equalsIgnoreCase("Aurillac")){selected.add(city);}
            if(city.getPostcode().startsWith("16") && city.getName().equalsIgnoreCase("Angoulême")){selected.add(city);}
            if(city.getPostcode().startsWith("17") && city.getName().equalsIgnoreCase("Rochelle")){selected.add(city);}
            if(city.getPostcode().startsWith("18") && city.getName().equalsIgnoreCase("Bourges")){selected.add(city);}
            if(city.getPostcode().startsWith("19") && city.getName().equalsIgnoreCase("Tulle")){selected.add(city);}
            if(city.getPostcode().startsWith("2A") && city.getName().equalsIgnoreCase("Ajaccio")){selected.add(city);}
            if(city.getPostcode().startsWith("2B") && city.getName().equalsIgnoreCase("Bastia")){selected.add(city);}
            if(city.getPostcode().startsWith("21") && city.getName().equalsIgnoreCase("Dijon")){selected.add(city);}
            if(city.getPostcode().startsWith("22") && city.getName().equalsIgnoreCase("Saint-Brieuc")){selected.add(city);}
            if(city.getPostcode().startsWith("23") && city.getName().equalsIgnoreCase("Guéret")){selected.add(city);}
            if(city.getPostcode().startsWith("24") && city.getName().equalsIgnoreCase("Périgueux")){selected.add(city);}
            if(city.getPostcode().startsWith("25") && city.getName().equalsIgnoreCase("Besançon")){selected.add(city);}
            if(city.getPostcode().startsWith("26") && city.getName().equalsIgnoreCase("Valence")){selected.add(city);}
            if(city.getPostcode().startsWith("27") && city.getName().equalsIgnoreCase("Évreux")){selected.add(city);}
            if(city.getPostcode().startsWith("28") && city.getName().equalsIgnoreCase("Chartres")){selected.add(city);}
            if(city.getPostcode().startsWith("29") && city.getName().equalsIgnoreCase("Quimper")){selected.add(city);}
            if(city.getPostcode().startsWith("30") && city.getName().equalsIgnoreCase("Nîmes")){selected.add(city);}
            if(city.getPostcode().startsWith("31") && city.getName().equalsIgnoreCase("Toulouse")){selected.add(city);}
            if(city.getPostcode().startsWith("32") && city.getName().equalsIgnoreCase("Auch")){selected.add(city);}
            if(city.getPostcode().startsWith("33") && city.getName().equalsIgnoreCase("Bordeaux")){selected.add(city);}
            if(city.getPostcode().startsWith("34") && city.getName().equalsIgnoreCase("Montpellier")){selected.add(city);}
            if(city.getPostcode().startsWith("35") && city.getName().equalsIgnoreCase("Rennes")){selected.add(city);}
            if(city.getPostcode().startsWith("36") && city.getName().equalsIgnoreCase("Châteauroux")){selected.add(city);}
            if(city.getPostcode().startsWith("37") && city.getName().equalsIgnoreCase("Tours")){selected.add(city);}
            if(city.getPostcode().startsWith("38") && city.getName().equalsIgnoreCase("Grenoble")){selected.add(city);}
            if(city.getPostcode().startsWith("39") && city.getName().equalsIgnoreCase("Lons-le-Saunier")){selected.add(city);}
            if(city.getPostcode().startsWith("40") && city.getName().equalsIgnoreCase("Mont-de-Marsan")){selected.add(city);}
            if(city.getPostcode().startsWith("41") && city.getName().equalsIgnoreCase("Blois")){selected.add(city);}
            if(city.getPostcode().startsWith("42") && city.getName().equalsIgnoreCase("Saint-Étienne")){selected.add(city);}
            if(city.getPostcode().startsWith("43") && city.getName().equalsIgnoreCase("Puy-en-Velay")){selected.add(city);}
            if(city.getPostcode().startsWith("44") && city.getName().equalsIgnoreCase("Nantes")){selected.add(city);}
            if(city.getPostcode().startsWith("45") && city.getName().equalsIgnoreCase("Orléans")){selected.add(city);}
            if(city.getPostcode().startsWith("46") && city.getName().equalsIgnoreCase("Cahors")){selected.add(city);}
            if(city.getPostcode().startsWith("47") && city.getName().equalsIgnoreCase("Agen")){selected.add(city);}
            if(city.getPostcode().startsWith("48") && city.getName().equalsIgnoreCase("Mende")){selected.add(city);}
            if(city.getPostcode().startsWith("49") && city.getName().equalsIgnoreCase("Angers")){selected.add(city);}
            if(city.getPostcode().startsWith("50") && city.getName().equalsIgnoreCase("Saint-Lô")){selected.add(city);}
            if(city.getPostcode().startsWith("51") && city.getName().equalsIgnoreCase("Châlons-en-Champagne")){selected.add(city);}
            if(city.getPostcode().startsWith("52") && city.getName().equalsIgnoreCase("Chaumont")){selected.add(city);}
            if(city.getPostcode().startsWith("53") && city.getName().equalsIgnoreCase("Laval")){selected.add(city);}
            if(city.getPostcode().startsWith("54") && city.getName().equalsIgnoreCase("Nancy")){selected.add(city);}
            if(city.getPostcode().startsWith("55") && city.getName().equalsIgnoreCase("Bar-le-Duc")){selected.add(city);}
            if(city.getPostcode().startsWith("56") && city.getName().equalsIgnoreCase("Vannes")){selected.add(city);}
            if(city.getPostcode().startsWith("57") && city.getName().equalsIgnoreCase("Metz")){selected.add(city);}
            if(city.getPostcode().startsWith("58") && city.getName().equalsIgnoreCase("Nevers")){selected.add(city);}
            if(city.getPostcode().startsWith("59") && city.getName().equalsIgnoreCase("Lille")){selected.add(city);}
            if(city.getPostcode().startsWith("60") && city.getName().equalsIgnoreCase("Beauvais")){selected.add(city);}
            if(city.getPostcode().startsWith("61") && city.getName().equalsIgnoreCase("Alençon")){selected.add(city);}
            if(city.getPostcode().startsWith("62") && city.getName().equalsIgnoreCase("Arras")){selected.add(city);}
            if(city.getPostcode().startsWith("63") && city.getName().equalsIgnoreCase("Clermont-Ferrand")){selected.add(city);}
            if(city.getPostcode().startsWith("64") && city.getName().equalsIgnoreCase("Pau")){selected.add(city);}
            if(city.getPostcode().startsWith("65") && city.getName().equalsIgnoreCase("Tarbes")){selected.add(city);}
            if(city.getPostcode().startsWith("66") && city.getName().equalsIgnoreCase("Perpignan")){selected.add(city);}
            if(city.getPostcode().startsWith("67") && city.getName().equalsIgnoreCase("Strasbourg")){selected.add(city);}
            if(city.getPostcode().startsWith("68") && city.getName().equalsIgnoreCase("Colmar")){selected.add(city);}
            if(city.getPostcode().startsWith("69") && city.getName().equalsIgnoreCase("Lyon")){selected.add(city);}
            if(city.getPostcode().startsWith("70") && city.getName().equalsIgnoreCase("Vesoul")){selected.add(city);}
            if(city.getPostcode().startsWith("71") && city.getName().equalsIgnoreCase("Mâcon")){selected.add(city);}
            if(city.getPostcode().startsWith("72") && city.getName().equalsIgnoreCase("Mans")){selected.add(city);}
            if(city.getPostcode().startsWith("73") && city.getName().equalsIgnoreCase("Chambéry")){selected.add(city);}
            if(city.getPostcode().startsWith("74") && city.getName().equalsIgnoreCase("Annecy")){selected.add(city);}
            if(city.getPostcode().startsWith("75") && city.getName().equalsIgnoreCase("Paris")){selected.add(city);}
            if(city.getPostcode().startsWith("76") && city.getName().equalsIgnoreCase("Rouen")){selected.add(city);}
            if(city.getPostcode().startsWith("77") && city.getName().equalsIgnoreCase("Melun")){selected.add(city);}
            if(city.getPostcode().startsWith("78") && city.getName().equalsIgnoreCase("Versailles")){selected.add(city);}
            if(city.getPostcode().startsWith("79") && city.getName().equalsIgnoreCase("Niort")){selected.add(city);}
            if(city.getPostcode().startsWith("80") && city.getName().equalsIgnoreCase("Amiens")){selected.add(city);}
            if(city.getPostcode().startsWith("81") && city.getName().equalsIgnoreCase("Albi")){selected.add(city);}
            if(city.getPostcode().startsWith("82") && city.getName().equalsIgnoreCase("Montauban")){selected.add(city);}
            if(city.getPostcode().startsWith("83") && city.getName().equalsIgnoreCase("Toulon")){selected.add(city);}
            if(city.getPostcode().startsWith("84") && city.getName().equalsIgnoreCase("Avignon")){selected.add(city);}
            if(city.getPostcode().startsWith("85") && city.getName().equalsIgnoreCase("Roche-sur-Yon")){selected.add(city);}
            if(city.getPostcode().startsWith("86") && city.getName().equalsIgnoreCase("Poitiers")){selected.add(city);}
            if(city.getPostcode().startsWith("87") && city.getName().equalsIgnoreCase("Limoges")){selected.add(city);}
            if(city.getPostcode().startsWith("88") && city.getName().equalsIgnoreCase("Épinal")){selected.add(city);}
            if(city.getPostcode().startsWith("89") && city.getName().equalsIgnoreCase("Auxerre")){selected.add(city);}
            if(city.getPostcode().startsWith("90") && city.getName().equalsIgnoreCase("Belfort")){selected.add(city);}
            if(city.getPostcode().startsWith("91") && city.getName().equalsIgnoreCase("Évry")){selected.add(city);}
            if(city.getPostcode().startsWith("92") && city.getName().equalsIgnoreCase("Nanterre")){selected.add(city);}
            if(city.getPostcode().startsWith("93") && city.getName().equalsIgnoreCase("Bobigny")){selected.add(city);}
            if(city.getPostcode().startsWith("94") && city.getName().equalsIgnoreCase("Créteil")){selected.add(city);}
            if(city.getPostcode().startsWith("95") && city.getName().equalsIgnoreCase("Cergy")){selected.add(city);}
            if(city.getPostcode().startsWith("971") && city.getName().equalsIgnoreCase("Basse-Terre")){selected.add(city);}
            if(city.getPostcode().startsWith("972") && city.getName().equalsIgnoreCase("Fort-de-France")){selected.add(city);}
            if(city.getPostcode().startsWith("973") && city.getName().equalsIgnoreCase("Cayenne")){selected.add(city);}
            if(city.getPostcode().startsWith("974") && city.getName().equalsIgnoreCase("Saint-Denis")){selected.add(city);}
            if(city.getPostcode().startsWith("976") && city.getName().equalsIgnoreCase("Mamoudzou")){selected.add(city);}

        }

        return selected;
    }
}
