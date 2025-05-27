import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {


        WeatherTower weatherTower = new WeatherTower();

        Baloon baloon = new Baloon(0, "firstBaloon", new Coordinates(20, 30, 20));
        JetPlane jetPlane = new JetPlane(0, "firstBaloon", new Coordinates(20, 30, 20));
        Helicopter helicopter = new Helicopter(0, "firstBaloon", new Coordinates(20, 30, 20));

        weatherTower.register(baloon);
        weatherTower.register(jetPlane);
        weatherTower.register(helicopter);
        baloon.registerTower(weatherTower);
        jetPlane.registerTower(weatherTower);
        helicopter.registerTower(weatherTower);



        for (int i=0; i < 100; i++)
            weatherTower.changeWeather();

    }
}