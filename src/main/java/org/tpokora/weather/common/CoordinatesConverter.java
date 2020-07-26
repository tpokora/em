package org.tpokora.weather.common;

public class CoordinatesConverter {

    private CoordinatesConverter() {}

    public static double convertDecimalDegreeToDM(double input) {
        if (input == 0.0) {
            return input;
        }
        int wholeNumberPart = (int) input;
        double fracture = input - wholeNumberPart;
        int minutesFromFracture = 0;
        if (fracture != 0.0) {
            minutesFromFracture = (int)(fracture * 60);
        }
        return Double.parseDouble(String.format("%s.%s", wholeNumberPart, minutesFromFracture));
    }
}
