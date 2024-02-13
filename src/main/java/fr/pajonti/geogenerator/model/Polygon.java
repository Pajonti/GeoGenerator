package fr.pajonti.geogenerator.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polygon {

    private List<Coordinates> coordinates;
    public Polygon(){
        this.coordinates = new LinkedList<>();
    }
    public void addCoordinates(Coordinates c){
        this.coordinates.add(c);
    }
    public List<Coordinates> getCoordinates(){
        return this.coordinates;
    }
}
