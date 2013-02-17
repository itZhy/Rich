package Props;

import Player.Movement;
import Player.Observer;
import Player.Position;
import UI.UIObserver;

public class PropsManager implements Observer {
    private final Ownership ownership = new Ownership();
    private final PropsMap propsMap;

    public PropsManager(UIObserver ui) {
        propsMap = new PropsMap(ui);
    }

    public void handle(String roleName, Movement movement) {
        propsMap.trigger(movement);
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
        propsMap.put(position, prop);
        return true;
    }

    public boolean clean(String roleName, Position position) {
        if (!ownership.consume(roleName, new Robot())) {
            return false;
        }
        propsMap.cleanTheFront(position);
        return true;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                ownership.equals(((PropsManager) object).ownership) &&
                propsMap.equals(((PropsManager) object).propsMap);
    }
}