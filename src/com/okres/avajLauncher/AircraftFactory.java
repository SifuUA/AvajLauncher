package com.okres.avajLauncher;

public class AircraftFactory {
    public Flyable newAircraft(String type, String name, int longitude, int latitude, int height ) {
        return new Helicopter("AAA", new Coordinates(1,2,3));
    }
}
