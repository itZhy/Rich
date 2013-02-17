package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

import java.util.HashMap;
import java.util.Map;

public class PropsMap {
    private final Map<Position, Prop> props = new HashMap<Position, Prop>();
    private final UIObserver ui;
    private static final int CLEAN_RANGE = 10;

    public PropsMap(UIObserver ui)   {
        this.ui = ui;
    }


    public void put(Position position, Prop prop) {
        props.put(position, prop);
        prop.addToUI(ui, position);
    }

    public void cleanTheFront(Position position) {
        for (int step = 1; step <= CLEAN_RANGE; ++step) {
            Position positionInFront = position.move(step);
            removeProp(positionInFront);
        }
    }

    public void handle(Position position, Role role)    {
        if (props.containsKey(position))    {
            useProp(position, role);
        }
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() && props.equals(((PropsMap)object).props);
    }

    private void useProp(Position position, Role role) {
        props.get(position).handle(position, role);
        removeProp(position);
    }

    private void removeProp(Position position) {
        if (props.containsKey(position))    {
            props.get(position).removeFromUI(ui, position);
            props.remove(position);
        }
    }
}
