import java.util.HashMap;

public class Baloon extends Aircarft {
    
    private HashMap<String, Runnable> weatherActions;
    private String type;


    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
        
        type = "Baloon";
        weatherActions = new HashMap<>();
        weatherActions.put("SUN", () -> {
            writeMessage("Sunny skies — perfect for a smooth float.");
            updateCoordinates(2, 0, 4);
        });

        weatherActions.put("RAIN", () -> {
            writeMessage("Rain and hot air don’t mix well...");
            updateCoordinates(0, 0, -5);
        });

        weatherActions.put("FOG", () -> {
            writeMessage("Can’t see a thing — hope we don’t hit a tree.");
            updateCoordinates(0, 0, -3);
        });

        weatherActions.put("SNOW", () -> {
            writeMessage("Snow’s piling up... we’re going down gently.");
            updateCoordinates(0, 0, -15);
        });
    }

    @Override
    public void updateConditions() {
        Runnable action = weatherActions.get(this.weatherTower.getWeather());

        if (action != null)
            action.run();
        if (this.coordinates.getHeight() == 0) {
            this.landing();
            unregister();
        }
    }

    public String getIdentification() {
        return type + "#" + name + "(" + id + ")";
    }

    private void updateCoordinates(int longitudeOffset, int latitudeOffset, int heightOffset) {
        this.coordinates.updateLongitude(longitudeOffset);
        this.coordinates.updateLatitude(latitudeOffset);
        this.coordinates.updateHeight(heightOffset);
    }

    private void writeMessage(String message) {
        String msg = getIdentification() + ": " + message;
        System.out.println(msg);
    }

    private void landing() {
        writeMessage("Landing.");
    }

    private void unregister() {
        weatherTower.unregister(this);
    }
}
