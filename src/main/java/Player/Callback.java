package Player;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private List<Observer> forwardingObservers = new ArrayList<Observer>();
    private List<Observer> forwardedObservers = new ArrayList<Observer>();

    public void attachForwardingObserver(Observer observer) {
        forwardingObservers.add(observer);
    }

    public void attachForwardedObserver(Observer observer) {
        forwardedObservers.add(observer);
    }

    public void notifyWhileForwarding(String role, Movement movement) {
        for (Observer observer : forwardingObservers) {
            observer.handle(role, movement);
        }
    }

    public void notifyAfterForwarded(String role, Movement movement) {
        for (Observer observer : forwardedObservers) {
            observer.handle(role, movement);
        }
    }
}
