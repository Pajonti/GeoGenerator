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

            String polygonTypeString = cityCoordinatesObject.getString("type");
            PolygonTypes polygonType = polygonTypeString.equals("MultiPolygon") ? PolygonTypes.MULTIPLE_POLYGON : PolygonTypes.SIMPLE_POLYGON;

            for(int indexGeometry = 0; indexGeometry < cityCoordinatesObject.getJSONArray("coordinates").length(); indexGeometry++){
                Polygon area = new Polygon();

                JSONArray coordinatesArray = cityCoordinatesObject.getJSONArray("coordinates").getJSONArray(indexGeometry).getJSONArray(0);

                if(polygonType.equals(PolygonTypes.MULTIPLE_POLYGON)){
                    for(int indexCoordinate = 0; indexCoordinate < coordinatesArray.length(); indexCoordinate++){
                        JSONArray coordinatesEntry = coordinatesArray.getJSONArray(indexCoordinate);
                        area.addCoordinates(new Coordinates(coordinatesEntry.getBigDecimal(0), coordinatesEntry.getBigDecimal(1)));
                    }
                }
                else{
                    area.addCoordinates(new Coordinates(coordinatesArray.getBigDecimal(0), coordinatesArray.getBigDecimal(1)));
                }

                city.addCoordinates(area);
            }

            city.setCountry(Country.FRANCE);
            city.setPolygonType(polygonType);

            list.add(city);
            logger.info("Reading city : " + city.getCountry() + "-" + city.getPostcode() + " : " + city.getName() + " with " + city.getCoordinates().size() + " polygons.");
        }


        return list;
    }
}
