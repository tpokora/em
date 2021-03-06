package org.tpokora.domain.weather;


import org.tpokora.domain.weather.common.CoordinatesConverter;

public class Coordinates {
    
    private Double longitude;
    private Double latitude;
    private Double longitudeDM;
    private Double latitudeDM;
    
    public Coordinates() {
        this.setLongitude(0.0);
        this.setLatitude(0.0);
    }

    public Coordinates(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.longitudeDM = CoordinatesConverter.convertDecimalDegreeToDM(this.longitude);
        this.latitudeDM = CoordinatesConverter.convertDecimalDegreeToDM(this.latitude);
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitudeDM() {
        return longitudeDM;
    }

    public Double getLatitudeDM() {
        return latitudeDM;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", longitudeDM=" + longitudeDM +
                ", latitudeDM=" + latitudeDM +
                '}';
    }
}
