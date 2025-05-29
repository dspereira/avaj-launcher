package pt.dspereira.avajlauncher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pt.dspereira.avajlauncher.aircraft.AircraftFactory;
import pt.dspereira.avajlauncher.aircraft.Flyable;
import pt.dspereira.avajlauncher.exceptions.InvalidAircraftFormatException;
import pt.dspereira.avajlauncher.exceptions.InvalidIterationsException;
import pt.dspereira.avajlauncher.tower.WeatherTower;

public class Simulation {
    private int iterations;
    private WeatherTower tower;
    private Boolean isSetupSuccessful = false;

    public Simulation() {
        tower = new WeatherTower();
    }

    public void setup(String setupFilename) {
        int lineNumber = 1;
        try(BufferedReader reader = new BufferedReader(new FileReader(setupFilename))) {
            Flyable flyable;
            iterations = Integer.parseInt(reader.readLine());
            String line;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                flyable = getNewAircraft(line);
                flyable.registerTower(tower);
                tower.register(flyable);
            }
            if (lineNumber == 1) {
                lineNumber = 2;
                throw new InvalidAircraftFormatException("Invalid parameters for creating an aircraft. Expected format: <type> <name> <longitude> <latitude> <height>.");
            }
            if (iterations < 1) {
                throw new InvalidIterationsException("Invalid number of iterations: must be greater than zero.");
            }
            isSetupSuccessful = true;
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            //e.printStackTrace();
        }
        catch (NumberFormatException e) {
            System.out.println("Error: Invalid number of simulation iterations.");
            //e.printStackTrace();
        }
        catch (InvalidAircraftFormatException e) {
            System.out.println("Error on line " + lineNumber + ": " + e.getMessage());
        }
        catch (InvalidIterationsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void start() {
        if (!isSetupSuccessful) {
            Logger.clean();
            return ;
        }
        for (int i = 0; i < iterations; i++)
            tower.changeWeather();
    }

    private Flyable getNewAircraft(String line) throws InvalidAircraftFormatException {
        String[] words = line.split("\\s+");
        int longitude;
        int latitude;
        int height;

        if (words.length != 5)
            throw new InvalidAircraftFormatException("Invalid parameters for creating an aircraft. Expected format: <type> <name> <longitude> <latitude> <height>.");
    
        if (!words[0].equals("Baloon") && !words[0].equals("Helicopter") && !words[0].equals("JetPlane"))
            throw new InvalidAircraftFormatException("Unknown aircraft type. Expected one of: Baloon, JetPlane, Helicopter.");
    
        try {
            longitude = Integer.parseInt(words[2]);
            latitude = Integer.parseInt(words[3]);
            height = Integer.parseInt(words[4]);
            if (longitude < 0 || latitude < 0)
                throw new InvalidAircraftFormatException("Invalid coordinates: both longitude and latitude must be non-negative values.");
            if (height < 1 || height > 100)
                throw new InvalidAircraftFormatException("Invalid height: must be between 1 and 100.");
            
        }
        catch (NumberFormatException e) {
            throw new InvalidAircraftFormatException("Invalid coordinates.");
        }

        Flyable flyable = AircraftFactory.getInstance().newAircraft(words[0], words[1], new Coordinates(longitude, latitude, height));
        if (flyable == null)
            throw new InvalidAircraftFormatException("Failed creating aircraft.");
        return flyable;
    }
}