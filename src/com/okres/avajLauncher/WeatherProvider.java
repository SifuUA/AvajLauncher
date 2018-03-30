package com.okres.avajLauncher;

public class WeatherProvider {

    private WeatherProvider weatherProvider;

    private String weather [] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(WeatherProvider weatherProvider) {
        this.weatherProvider = weatherProvider;
    }

    public WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        return null;
    }
}
