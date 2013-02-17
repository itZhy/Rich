package Player;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void notify(Position position, String name) {
        for (Observer observer : observers) {
            observer.handle(position, name);
        }
    }
}
