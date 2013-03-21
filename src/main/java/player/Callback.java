package player;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private final List<Observer> forwardingObservers = new ArrayList<Observer>();
    private final List<Observer> forwardedObservers = new ArrayList<Observer>();

    public void attachForwardingObserver(Observer observer) {
        forwardingObservers.add(observer);
    }

    public void attachForwardedObserver(Observer observer) {
        forwardedObservers.add(observer);
    }

    public void notifyWhileForwarding(Role role, Movement movement) {
        for (Observer observer : forwardingObservers) {
            observer.handle(role, movement);
        }
    }

    public void notifyAfterForwarded(Role role, Movement movement) {
        for (Observer observer : forwardedObservers) {
            observer.handle(role, movement);
        }
    }
}
