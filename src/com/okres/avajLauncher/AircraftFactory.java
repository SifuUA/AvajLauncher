package com.okres.avajLauncher;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height ) {
        if (type.equals("Baloon")) {
            return new Baloon(name, new Coordinates(longitude,latitude,height));
        } else if (type.equals("JetPlane")) {

        }else
            return new Helicopter("AAA", new Coordinates(1,2,3));
        return null;
    }
}
