import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        WeatherTower weatherTower = new WeatherTower();

        Baloon baloon = new Baloon(0, "firstBaloon", new Coordinates(20, 30, 40));

        weatherTower.register(baloon);
        baloon.registerTower(weatherTower);

        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
                weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();
        weatherTower.changeWeather();

    }
}