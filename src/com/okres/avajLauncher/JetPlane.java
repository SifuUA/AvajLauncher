package com.okres.avajLauncher;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.setLatitude(coordinates.getLatitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
        } else if (weather.equals("RAIN")) {
            coordinates.setLatitude(coordinates.getLatitude() + 5);
        } else if (weather.equals("FOG")) {
            coordinates.setLatitude(coordinates.getLatitude() + 1);
        } else if (weather.equals("SNOW")) {
            coordinates.setHeight(coordinates.getHeight() - 7);
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
