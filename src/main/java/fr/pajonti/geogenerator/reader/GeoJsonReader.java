package fr.pajonti.geogenerator.reader;

import fr.pajonti.geogenerator.enums.Country;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class providing a reader for the GeoJSON files located in resources
 */
public class GeoJsonReader {
    private static final Logger logger = LogManager.getLogger(GeoJsonReader.class);
    private GeoJsonReader(){

    }

    public static String readCountryFile(Country country){
        String pathForGeoJSONFile = "geojsons/" + country.getCountryCode() + ".geojson";
        ClassLoader classLoader = GeoJsonReader.class.getClassLoader();
        try (InputStream is = classLoader.getResourceAsStream(pathForGeoJSONFile)) {
            if(is == null){
                logger.error("Unable to find file " + pathForGeoJSONFile);
                return null;
            }

            InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);

            BufferedReader reader = new BufferedReader(isr);

            StringBuilder jsonBuilder = new StringBuilder();

            String line;
            while((line = reader.readLine()) != null){
                jsonBuilder.append(line);
            }

            return jsonBuilder.toString();
        }
        catch (IOException ioe){
            logger.error("Unable to read GeoJSON file for country " + country);
            return null;
        }
    }
}
