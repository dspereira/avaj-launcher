package pt.dspereira.avajlauncher.aircraft;

import java.util.HashMap;

import pt.dspereira.avajlauncher.Coordinates;

public class Helicopter extends Aircarft{
    private HashMap<String, Action> weatherActions;

    public Helicopter(long id, String name, Coordinates coordinates) {
        super(id, name, coordinates);

        type = "Helicopter";
        weatherActions = new HashMap<>();
        weatherActions.put("SUN", () -> {
            writeMessage("Sun is out, time to flex these rotors!");
            updateCoordinates(10, 0, 2);
        });

        weatherActions.put("RAIN", () -> {
            writeMessage("Rain? Hope this thing floats.");
            updateCoordinates(5, 0, 0);
        });

        weatherActions.put("FOG", () -> {
            writeMessage("Fog again? Great... just great.");
            updateCoordinates(1, 0, 0);
        });

        weatherActions.put("SNOW", () -> {
            writeMessage("Snow way we are flying in this.");
            updateCoordinates(0, 0, -12);
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
