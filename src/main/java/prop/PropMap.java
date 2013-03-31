package prop;

import player.Movement;
import player.Position;
import player.Role;
import ui.UIObserver;
import utils.Checker;

import java.util.HashMap;
import java.util.Map;

class PropMap {
    private static final int CLEAN_RANGE = 10;
    private final Map<Position, Prop> props = new HashMap<Position, Prop>();
    private final UIObserver ui;

    public PropMap(UIObserver ui) {
        this.ui = ui;
    }

    public void put(Role role, Position position, Prop prop) {
        Checker.check(!props.containsKey(position), "此处已有道具，不能再放置其他道具了。");
        props.put(position, prop);
        prop.addToUI(role, ui, position);
    }

    public void cleanTheFront(Role role, Position position) {
        for (int step = 1; step <= CLEAN_RANGE; ++step) {
            removeProp(role, position.offset(step));
        }
    }

    public void trigger(Role role, Movement movement) {
        if (props.containsKey(movement.currentPosition())) {
            Prop prop = props.get(movement.currentPosition());
            removeProp(role, movement.currentPosition());
            prop.handle(movement);
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && props.equals(((PropMap) object).props);
    }

    private void removeProp(Role role, Position position) {
        if (props.containsKey(position)) {
            props.get(position).removeFromUI(role, ui, position);
            props.remove(position);
        }
    }
}
