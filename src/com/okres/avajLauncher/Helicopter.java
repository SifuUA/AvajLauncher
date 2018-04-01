package com.okres.avajLauncher;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            coordinates.setLongitude(coordinates.getLongitude() + 10);
            coordinates.setHeight(coordinates.getHeight() + 2);
            System.out.println("Helicopter" + "#" + this.name + "(" + this.id + "): " +
                    "This is hot!");
        } else if (weather.equals("RAIN")) {
            coordinates.setLongitude(coordinates.getLongitude() + 5);
            System.out.println("Helicopter" + "#" + this.name + "(" + this.id + "): " +
                    "It is raining. Better watch out of lighting.");
        } else if (weather.equals("FOG")) {
            coordinates.setLongitude(coordinates.getLongitude() + 1);
            System.out.println("Helicopter" + "#" + this.name + "(" + this.id + "): " +
                    "Do not see anything! We will crush!");
        } else if (weather.equals("SNOW")) {
            coordinates.setHeight(coordinates.getHeight() - 12);
            System.out.println("Helicopter" + "#" + this.name + "(" + this.id + "): " +
                    "My rotor is going to freeze!");
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
