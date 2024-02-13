package fr.pajonti.geogenerator.mappers;

import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.enums.PolygonTypes;
import fr.pajonti.geogenerator.model.Coordinates;
import fr.pajonti.geogenerator.model.GeoCity;
import fr.pajonti.geogenerator.model.Polygon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link CountryMapper} implementation for {@link fr.pajonti.geogenerator.enums.Country} France
 */
public class FranceMapper implements CountryMapper {
    private static final Logger logger = LogManager.getLogger(FranceMapper.class);

    /**
     * Mapping method
     *
     * @param source Source string
     * @return Array of GeoCity
     */
    @Override
    public List<GeoCity> mapStringToGeoCityList(String source) {
        List<GeoCity> list = new ArrayList<>();
        logger.info("Parsing France dataset");

        JSONObject o = new JSONObject(source);
        JSONArray firstLevelArray = o.getJSONArray("features");

        for(int index = 0; index < firstLevelArray.length(); index++){
            JSONObject cityObject = firstLevelArray.getJSONObject(index);
            JSONObject cityCoordinatesObject = cityObject.getJSONObject("geometry");

            GeoCity city = new GeoCity();
            city.setName(cityObject.getJSONObject("properties").getString("nom"));
            city.setPostcode(cityObject.getJSONObject("properties").getString("code"));

            for(int indexGeometry = 0; indexGeometry < cityCoordinatesObject.getJSONArray("coordinates").length(); indexGeometry++){
                Polygon area = new Polygon();

                //TODO : FIX ISSUE : DIFFERENT BEHAVIOUR ON MULTIPLE_POLYGONS OR SIMPLE_POLYGON (EXTRA LAYER OF ARRAY)
                JSONArray coordinatesArray = cityCoordinatesObject.getJSONArray("coordinates").getJSONArray(indexGeometry).getJSONArray(0);

                for(int indexCoordinate = 0; indexCoordinate < coordinatesArray.length(); indexCoordinate++){
                    JSONArray coordinatesEntry = coordinatesArray.getJSONArray(indexCoordinate);
                    area.addCoordinates(new Coordinates(coordinatesEntry.getBigDecimal(0), coordinatesEntry.getBigDecimal(1)));
                }

                city.addCoordinates(area);
            }

            city.setCountry(Country.FRANCE);
            city.setPolygonType(city.getCoordinates().size() > 1 ? PolygonTypes.MULTIPLE_POLYGON : PolygonTypes.SIMPLE_POLYGON);

            list.add(city);

        }

        return list;
    }
}
