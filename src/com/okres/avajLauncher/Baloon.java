package com.okres.avajLauncher;

public class Baloon extends Aircraft implements Flyable{

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        System.out.println("");
        this.weatherTower.register(this);

    }
}
