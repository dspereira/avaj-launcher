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

        Flyable flyable = null;

        if (type == "Helicopter")
            flyable = new Helicopter(++id, name, coordinates);
        else if (type == "Baloon")
            flyable = new Baloon(++id, name, coordinates);
        else if (type == "JetPlane")
            flyable = new JetPlane(++id, name, coordinates);
        else
            flyable = null;
        return flyable;
    }  
}