import java.util.List;
import java.util.ArrayList;

class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> toRemove = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        Logger.log("Tower says: " + ((Aircarft) flyable).getIdentification() + " registered to weather tower.");
    }

    public void unregister(Flyable flyable) {
        //observers.remove(flyable);
        toRemove.add(flyable);
        Logger.log("Tower says: " + ((Aircarft) flyable).getIdentification() + " unregistered from weather tower.");
    }

    protected void conditionChanged() {
        for (Flyable observer : observers) {
            observer.updateConditions();
        }
        
        for (Flyable observer: toRemove) {
            observers.remove(observer);
        }
        toRemove.clear();
    }
}
