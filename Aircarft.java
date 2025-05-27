public class Aircarft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected String type;

    protected Aircarft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.type = "Aircraft";
    }

    @Override
    public void updateConditions() {}

    protected String getIdentification() {
        return type + "#" + name + "(" + id + ")";
    }

    protected void updateCoordinates(int longitudeOffset, int latitudeOffset, int heightOffset) {
        this.coordinates.updateLongitude(longitudeOffset);
        this.coordinates.updateLatitude(latitudeOffset);
        this.coordinates.updateHeight(heightOffset);
    }

    protected void writeMessage(String message) {
        String msg = getIdentification() + ": " + message;
        System.out.println(msg);
    }

    protected void landing() {
        writeMessage("Landing.");
    }

    protected void unregister() {
        weatherTower.unregister(this);
    }   
}
