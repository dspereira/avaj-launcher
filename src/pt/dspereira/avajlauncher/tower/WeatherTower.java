package pt.dspereira.avajlauncher.tower;

import pt.dspereira.avajlauncher.Coordinates;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getInstance().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        this.conditionChanged();
    }
}
