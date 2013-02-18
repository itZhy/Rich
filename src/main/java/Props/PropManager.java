package Props;

import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.UIObserver;

public class PropManager implements Observer {
    private final Ownership ownership = new Ownership();
    private final PropMap propMap;

    public PropManager(UIObserver ui) {
        propMap = new PropMap(ui);
    }

    public void handle(String roleName, Movement movement) {
        propMap.trigger(movement);
    }

    public void add(String roleName, int point) {
        ownership.add(roleName, point);
    }

    public void buy(String roleName, Prop prop) {
        ownership.buy(roleName, prop);
    }

    public boolean put(String roleName, Prop prop, Position position) {
        if (!ownership.consume(roleName, prop)) {
            return false;
        }
        propMap.put(position, prop);
        return true;
    }

    public boolean clean(String roleName, Position position) {
        if (!ownership.consume(roleName, new Robot())) {
            return false;
        }
        propMap.cleanTheFront(position);
        return true;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ownership.equals(((PropManager) object).ownership) &&
                propMap.equals(((PropManager) object).propMap);
    }
}