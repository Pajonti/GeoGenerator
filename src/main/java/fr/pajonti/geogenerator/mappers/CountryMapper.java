package fr.pajonti.geogenerator.mappers;

import fr.pajonti.geogenerator.model.GeoCity;

import java.util.List;

/**
 * Public interface of mappers used to convert a GeoJSON file to GeoCity objects
 */
public interface CountryMapper {

    /**
     * Mapping method
     * @param source Source string
     * @return Array of GeoCity
     */
    public List<GeoCity> mapStringToGeoCityList(String source);
}
