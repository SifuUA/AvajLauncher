package com.okres.avajLauncher.Aircrafts;

public final class WeatherProvider {

    private static WeatherProvider weatherProvider;
    private String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = (coordinates.getLatitude() + coordinates.getLongitude() +
                coordinates.getHeight()) % 4;
        return weather[sum];
    }
}
