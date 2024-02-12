package fr.pajonti.geogenerator.reader;

import fr.pajonti.geogenerator.enums.Country;

import java.io.IOException;
import java.io.InputStream;
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
        try (InputStream is = GeoJsonReader.class.getClassLoader().getResourceAsStream("file.txt")) {
            logger.info("File found");
            return "todo";
        }
        catch (IOException ioe){
            logger.error("Unable to read GeoJSON file for country " + country);
            return null;
        }
    }
}
