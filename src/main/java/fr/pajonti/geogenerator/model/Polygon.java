package fr.pajonti.geogenerator.model;

import java.util.ArrayList;
import java.util.List;

public class Polygon {

    private List<Coordinates> coordinates;
    public Polygon(){
        this.coordinates = new ArrayList<>();
    }

    public void addCoordinates(Coordinates c){
        this.coordinates.add(c);
    }
}
