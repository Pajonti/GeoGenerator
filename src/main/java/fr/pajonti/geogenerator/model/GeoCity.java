package fr.pajonti.geogenerator.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import fr.pajonti.geogenerator.enums.Country;
import fr.pajonti.geogenerator.enums.PolygonTypes;
import fr.pajonti.geogenerator.serializers.GeoCitySerializer;

import java.util.ArrayList;
import java.util.List;

@JsonSerialize(using = GeoCitySerializer.class)
public class GeoCity {
    /**
     * Name of the city
     */
    private String name;
    /**
     * Country from there the city is originating from
     */
    private Country country;
    /**
     * If it exists, a unique postcode for said city
     */
    private String postcode;

    /**
     * How the city should be represented : Multiple polygons or a simple one
     */
    private PolygonTypes polygonType;

    /**
     * Map of coordinates representing the city location on a map
     */
    private List<Polygon> coordinates;


    public GeoCity(){
        this.coordinates = new ArrayList<>();
    }

    public GeoCity(String name, Country country, String postcode, List<Polygon> coordinates) {
        this.name = name;
        this.country = country;
        this.postcode = postcode;
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public PolygonTypes getPolygonType() {
        return polygonType;
    }

    public void setPolygonType(PolygonTypes polygonType) {
        this.polygonType = polygonType;
    }

    public List<Polygon> getCoordinates() {
        return coordinates;
    }

    public void addCoordinates(Polygon polygon) {
        this.coordinates.add(polygon);
    }

    @Override
    public String toString() {
        return "GeoCity{" +
                "name='" + name + '\'' +
                ", country=" + country +
                ", postcode='" + postcode + '\'' +
                ", polygonType=" + polygonType +
                ", coordinates=" + coordinates +
                '}';
    }
}
