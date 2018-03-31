package com.okres.avajLauncher;

public final class WeatherProvider {

    private static WeatherProvider weatherProvider;

    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {

        return null;
    }
}
