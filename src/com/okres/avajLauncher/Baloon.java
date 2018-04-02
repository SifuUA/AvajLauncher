package com.okres.avajLauncher;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            this.coordinates.setLongitude(coordinates.getLongitude() + 2);
            this.coordinates.setHeight(coordinates.getHeight() + 4);
            Logger.getLogger().loggerAddLog("Ballon" + "#" + this.name + "(" +
                    this.id + "): " + "Wow, such a shining weather!");
        } else if (weather.equals("RAIN")) {
            this.coordinates.setHeight(coordinates.getHeight() - 5);
            Logger.getLogger().loggerAddLog("Ballon" + "#" + this.name + "(" +
                    this.id + "): " + "Damn, it is raining!");
        } else if (weather.equals("FOG")) {
            this.coordinates.setHeight(coordinates.getHeight() - 3);
            Logger.getLogger().loggerAddLog("Ballon" + "#" + this.name + "(" +
                    this.id + "): " + "I must turn on my fog lights!");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(coordinates.getHeight() - 15);
            Logger.getLogger().loggerAddLog("Ballon" + "#" + this.name + "(" +
                    this.id + "): " + "Winter is coming! Brrrr!");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() <= 0) {
            Logger.getLogger().loggerAddLog("Ballon" + "#" + this.name + "(" +
                    this.id + "): " + "Landing.");
            weatherTower.unregister(this);
            Logger.getLogger().loggerAddLog("Tower says: Ballon" + "#" +
                    this.name + "(" + this.id + "): " + "unregistered from " +
                    "weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        Logger.getLogger().loggerAddLog("Tower says: " + this.getClass().getSimpleName() +
                "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
