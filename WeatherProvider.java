import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider INSTANCE;
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