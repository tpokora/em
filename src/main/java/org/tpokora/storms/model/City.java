package org.tpokora.storms.model;

public class City {
    private String name;
    private Coordinates coordinates;

    public City() {
    }

    public City(String x, String y) {
        this.coordinates = new Coordinates();
        this.coordinates.setX(x);
        this.coordinates.setY(y);
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}