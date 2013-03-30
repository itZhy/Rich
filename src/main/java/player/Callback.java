package player;

import java.util.ArrayList;
import java.util.List;

public class Callback {
    private final List<PlayerObserver> forwardingObservers = new ArrayList<PlayerObserver>();
    private final List<PlayerObserver> forwardedObservers = new ArrayList<PlayerObserver>();

    public void attachForwardingObserver(PlayerObserver observer) {
        forwardingObservers.add(observer);
    }

    public void attachForwardedObserver(PlayerObserver observer) {
        forwardedObservers.add(observer);
    }

    public void notifyWhileForwarding(Role role, Movement movement) {
        for (PlayerObserver observer : forwardingObservers) {
            observer.handle(role, movement);
        }
    }

    public void notifyAfterForwarded(Role role, Movement movement) {
        for (PlayerObserver observer : forwardedObservers) {
            observer.handle(role, movement);
        }
    }
}
