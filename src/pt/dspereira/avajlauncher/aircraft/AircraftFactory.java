package pt.dspereira.avajlauncher.aircraft;

import pt.dspereira.avajlauncher.Coordinates;

public class AircraftFactory {
    private static AircraftFactory INSTANCE = null;
    private static long id = 0;
    
    private AircraftFactory() {}

    public static AircraftFactory getInstance() {
        if (INSTANCE == null)
            return INSTANCE = new AircraftFactory();
        else
            return INSTANCE;
    }

    public Flyable newAircraft(String type, String name, Coordinates coordinates) {
        Flyable flyable;
    
        if (type.equals("Helicopter"))
            flyable = new Helicopter(++id, name, coordinates);
        else if (type.equals("Baloon"))
            flyable = new Baloon(++id, name, coordinates);
        else if (type.equals("JetPlane"))
            flyable = new JetPlane(++id, name, coordinates);
        else
            flyable = null;
        return flyable;
    }  
}