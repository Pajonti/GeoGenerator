package fr.pajonti.geogenerator.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import fr.pajonti.geogenerator.enums.PolygonTypes;
import fr.pajonti.geogenerator.model.Coordinates;
import fr.pajonti.geogenerator.model.GeoCity;
import fr.pajonti.geogenerator.model.Polygon;

import java.io.IOException;

public class GeoCitySerializer extends StdSerializer<GeoCity> {
    protected GeoCitySerializer(Class<GeoCity> t) {
        super(t);
    }

    protected GeoCitySerializer() {
        super(GeoCity.class);
    }

    @Override
    public void serialize(GeoCity geoCity, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("type", "FeatureCollection");
        jsonGenerator.writeArrayFieldStart("features");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("type", "Feature");
            jsonGenerator.writeObjectFieldStart("properties");
                jsonGenerator.writeStringField("name", "Polygon for " + geoCity.getName());
                jsonGenerator.writeEndObject();
            jsonGenerator.writeObjectFieldStart("geometry");
                jsonGenerator.writeStringField("type", PolygonTypes.SIMPLE_POLYGON.getType());
                jsonGenerator.writeArrayFieldStart("coordinates");

                    for(Polygon polygon : geoCity.getCoordinates()){
                        jsonGenerator.writeStartArray();

                            for(Coordinates coordinate : polygon.getCoordinates()){
                                jsonGenerator.writeStartArray();
                                    jsonGenerator.writeNumber(coordinate.getX());
                                    jsonGenerator.writeNumber(coordinate.getY());
                                jsonGenerator.writeEndArray();
                            }

                        jsonGenerator.writeEndArray();
                    }

                    jsonGenerator.writeEndArray();
                jsonGenerator.writeEndObject();
            jsonGenerator.writeEndObject();
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }
}
