package pt.dspereira.avajlauncher;

public class Coordinates {
    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int longitude, int latitude, int height) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.height = clamp(height);
    }

    public int getLongitude() {
        return longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getHeight() {
        return height;
    }

    public void updateLongitude(int longitude) {
        this.longitude += longitude;
    }

    public void updateLatitude(int latitude) {
        this.latitude += latitude;
    }

    public void updateHeight(int height) {
        this.height += height;
        this.height = clamp(this.height);
    }

    private int clamp(int value) {
        if (value < 0)
            value = 0;
        else if (value > 100)
            value = 100;
        return value;
    }
}