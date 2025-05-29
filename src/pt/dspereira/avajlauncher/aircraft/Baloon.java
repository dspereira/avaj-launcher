package pt.dspereira.avajlauncher.aircraft;

import java.util.HashMap;

import pt.dspereira.avajlauncher.Coordinates;

public class Baloon extends Aircarft {
    private HashMap<String, Action> weatherActions;

    public Baloon(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        type = "Baloon";
        weatherActions = new HashMap<>();
        weatherActions.put("SUN", () -> {
            writeMessage("Sunny skies - perfect for a smooth float.");
            updateCoordinates(2, 0, 4);
        });

        weatherActions.put("RAIN", () -> {
            writeMessage("Rain and hot air do not mix well...");
            updateCoordinates(0, 0, -5);
        });

        weatherActions.put("FOG", () -> {
            writeMessage("Can not see a thing - hope we do not hit a tree.");
            updateCoordinates(0, 0, -3);
        });

        weatherActions.put("SNOW", () -> {
            writeMessage("Snow is piling up... we are going down gently.");
            updateCoordinates(0, 0, -15);
        });
    }

    @Override
    public void updateConditions() {
        if (this.weatherTower == null)
            return ;
        
        Action action = weatherActions.get(this.weatherTower.getWeather(this.coordinates));

        if (action != null)
            action.execute();
        if (this.coordinates.getHeight() == 0) {
            this.landing();
            unregister();
        }
    }

    @FunctionalInterface
    private interface Action {
        void execute();
    }   
}
