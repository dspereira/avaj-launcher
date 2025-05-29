package pt.dspereira.avajlauncher.tower;

import java.util.Random;

import pt.dspereira.avajlauncher.Coordinates;

public class WeatherProvider {
    private static WeatherProvider INSTANCE = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private Random random = new Random();
    
    private WeatherProvider() {}

    public static WeatherProvider getInstance() {
        if (INSTANCE == null)
            return INSTANCE = new WeatherProvider();
        else
            return INSTANCE;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int index = (coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight() + random.nextInt(100)) % 4;
        return weather[index];
    }
}
