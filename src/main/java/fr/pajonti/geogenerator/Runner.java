package fr.pajonti.geogenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.helpers.MapperHelper;
import fr.pajonti.geogenerator.model.GeoCity;
import fr.pajonti.geogenerator.reader.GeoJsonReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final Logger logger = LogManager.getLogger(Runner.class);
    public static void main(String[] args) throws JsonProcessingException {

        String s = GeoJsonReader.readCountryFile(Country.FRANCE);
        List<GeoCity> geoCities = MapperHelper.getCountryMapperByCountry(Country.FRANCE).mapStringToGeoCityList(s);

        for(GeoCity city : geoCities){
            if(city.getName().equals("Paris")){
                logger.info("Reading city : " + city.getCountry() + "-" + city.getPostcode() + " : " + city.getName() + " with " + city.getCoordinates().size() + " polygons.");
                ObjectMapper mapper = new ObjectMapper();

                logger.info(mapper.writeValueAsString(city));
            }
        }

    }
}
