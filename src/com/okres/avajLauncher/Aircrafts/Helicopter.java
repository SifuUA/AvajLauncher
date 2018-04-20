package com.okres.avajLauncher.Aircrafts;

import com.okres.avajLauncher.Logging.Logger;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            this.coordinates.setLongitude(coordinates.getLongitude() + 10);
            this.coordinates.setHeight(coordinates.getHeight() + 2);
            Logger.getLogger().loggerAddLog("Helicopter" + "#" + this.name +
                    "(" + this.id + "): " + "This is hot!");
        } else if (weather.equals("RAIN")) {
            this.coordinates.setLongitude(coordinates.getLongitude() + 5);
            Logger.getLogger().loggerAddLog("Helicopter" + "#" + this.name +
                    "(" + this.id + "): " + "It is raining. Better watch out " +
                    "of " + "lighting.");
        } else if (weather.equals("FOG")) {
            this.coordinates.setLongitude(coordinates.getLongitude() + 1);
            Logger.getLogger().loggerAddLog("Helicopter" + "#" + this.name +
                    "(" + this.id + "): " + "Do not see anything! " +
                    "We will crush!");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(coordinates.getHeight() - 12);
            Logger.getLogger().loggerAddLog("Helicopter" + "#" + this.name +
                    "(" + this.id + "): " + "My rotor is going to freeze!");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().loggerAddLog("Helicopter" + "#" + this.name +
                    "(" + this.id + "): " + "Landing.");
            weatherTower.unregister(this);
            Logger.getLogger().loggerAddLog("Tower says: Helicopter" + "#" +
                    this.name + "(" + this.id + "): " + "unregistered from " +
                    "weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        Logger.getLogger().loggerAddLog("Tower says: " +
                this.getClass().getSimpleName() +
                "#" + this.name + "(" + this.id + ")" +
                " registered to weather tower.");
    }
}
