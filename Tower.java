import java.util.List;
import java.util.ArrayList;

class Tower {
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> toRemove = new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
        System.out.println("Tower says: " + ((Baloon) flyable).getIdentification() + " registered to weather tower."); // Put getIdentification in the Flyable like an abstract

    }

    public void unregister(Flyable flyable) {
        //observers.remove(flyable);
        toRemove.add(flyable);
        System.out.println("Tower says: " + ((Baloon) flyable).getIdentification() + " unregistered from weather tower."); // Put getIdentification in the Flyable like an abstract
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
