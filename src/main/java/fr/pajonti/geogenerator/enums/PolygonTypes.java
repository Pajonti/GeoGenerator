package fr.pajonti.geogenerator.enums;

public enum PolygonTypes {
    SIMPLE_POLYGON("Polygon"),
    MULTIPLE_POLYGON("MultiPolygon");

    private final String type;

    PolygonTypes(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
