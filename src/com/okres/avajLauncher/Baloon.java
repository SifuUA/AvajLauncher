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
            coordinates.setLongitude(coordinates.getLongitude() + 2);
            coordinates.setHeight(coordinates.getHeight() + 4);
            System.out.println("Ballon" + "#" + this.name + "(" + this.id + "): " + "Wow, such a cool weather!!!");
        } else if (weather.equals("RAIN")) {
            coordinates.setHeight(coordinates.getHeight() - 5);
        } else if (weather.equals("FOG")) {
            coordinates.setHeight(coordinates.getHeight() - 3);
        } else if (weather.equals("SNOW")) {
            coordinates.setHeight(coordinates.getHeight() - 15);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + this.getClass().getSimpleName() +
                "#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
