public class Aircarft extends Flyable{
    protected long id;
    protected String name;
    protected Coordinates coordinates;

    protected Aircarft(long id, String name, Coordinates coordinates) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void updateConditions() {
        
    }
}