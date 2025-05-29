package pt.dspereira.avajlauncher.aircraft;

import java.util.HashMap;

import pt.dspereira.avajlauncher.Coordinates;

public class JetPlane extends Aircarft {
    private HashMap<String, Action> weatherActions;

    public JetPlane(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);
        
        type = "JetPlane";
        weatherActions = new HashMap<>();
        weatherActions.put("SUN", () -> {
            writeMessage("Clear skies - time to break the sound barrier.");
            updateCoordinates(0, 10, 2);
        });

        weatherActions.put("RAIN", () -> {
            writeMessage("Rain ahead - activating anti-icing systems.");
            updateCoordinates(0, 5, 0);
        });

        weatherActions.put("FOG", () -> {
            writeMessage("Instrument flight only - visibility zero.");
            updateCoordinates(0, 1, 0);
        });

        weatherActions.put("SNOW", () -> {
            writeMessage("Snowstorm incoming - adjusting altitude for safety.");
            updateCoordinates(0, 0, -7);
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
