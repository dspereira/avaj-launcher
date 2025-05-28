import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        simulation.setup("scenario.txt");
        simulation.start();

        /*
        WeatherTower weatherTower = new WeatherTower();

        AircraftFactory aFactory = AircraftFactory.getInstance();

        Flyable baloon = aFactory.newAircraft("Baloon", "bal", new Coordinates(20, 30, 20));
        baloon.registerTower(weatherTower);
        weatherTower.register(baloon);

        Flyable jetPlane = aFactory.newAircraft("JetPlane", "jet", new Coordinates(20, 30, 20));
        jetPlane.registerTower(weatherTower);
        weatherTower.register(jetPlane);

        Flyable helicopter = aFactory.newAircraft("Helicopter", "hel", new Coordinates(20, 30, 20));
        helicopter.registerTower(weatherTower);
        weatherTower.register(helicopter);
        */

        /* 
        Baloon baloon = new Baloon(0, "firstBaloon", new Coordinates(20, 30, 20));
        JetPlane jetPlane = new JetPlane(0, "firstBaloon", new Coordinates(20, 30, 20));
        Helicopter helicopter = new Helicopter(0, "firstBaloon", new Coordinates(20, 30, 20));

        weatherTower.register(baloon);
        weatherTower.register(jetPlane);
        weatherTower.register(helicopter);
        baloon.registerTower(weatherTower);
        jetPlane.registerTower(weatherTower);
        helicopter.registerTower(weatherTower);
        */


        //for (int i=0; i < 100; i++)
        //    weatherTower.changeWeather();


        //InputStreamReader in = new InputStreamReader();
        //BufferedReader bf = new BufferedReader();
    }
}