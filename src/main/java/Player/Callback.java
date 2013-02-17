package Player;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void detach(Observer observer){
        observers.remove(observer);
    }

    public void notify(Position position, String name) {
        for (int index = 0; index < observers.size(); ++index) {
            observers.get(index).handle(position, name);
        }
    }
}
