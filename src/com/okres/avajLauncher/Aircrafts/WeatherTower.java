package com.okres.avajLauncher.Aircrafts;

public class WeatherTower extends Tower {

    String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    void changeWeather() {
        this.conditionsChanged();
    }
}
