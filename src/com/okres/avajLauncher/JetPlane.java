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
            this.coordinates.setLatitude(coordinates.getLatitude() + 10);
            this.coordinates.setHeight(coordinates.getHeight() + 2);
            System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): " +
                    "Lets enjoy such cool weather!");
        } else if (weather.equals("RAIN")) {
            this.coordinates.setLatitude(coordinates.getLatitude() + 5);
            System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): " +
                    "Its raining cats and dogs!");
        } else if (weather.equals("FOG")) {
            this.coordinates.setLatitude(coordinates.getLatitude() + 1);
            System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): " +
                    "Should reduce speed, poor visibility.");
        } else if (weather.equals("SNOW")) {
            this.coordinates.setHeight(coordinates.getHeight() - 7);
            System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): " +
                    "Danger, the temperature go down. Turbojets are is at risk.");
        }
        if (this.coordinates.getHeight() > 100)
            this.coordinates.setHeight(100);
        if (this.coordinates.getHeight() <= 0) {
            System.out.println("JetPlane" + "#" + this.name + "(" + this.id + "): " +
                    "Landing.");
            weatherTower.unregister(this);
            System.out.println("Tower says: JetPlane" + "#" + this.name + "(" +
                    this.id + "): " + "unregistered from weather tower.");
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
        System.out.println("Tower says: " + this.getClass().getSimpleName() + "#" +
                this.name + "(" + this.id + ")" + " registered to weather tower.");
    }
}
