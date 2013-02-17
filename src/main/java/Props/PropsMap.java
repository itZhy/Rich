package Props;

import Player.Position;
import Player.Movement;
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
            removeProp(position.move(step));
        }
    }

    public void trigger(Movement movement)    {
        if (props.containsKey(movement.currentPosition()))    {
            useProp(movement);
        }
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() && props.equals(((PropsMap)object).props);
    }

    private void useProp(Movement movement) {
        props.get(movement.currentPosition()).handle(movement);
        removeProp(movement.currentPosition());
    }

    private void removeProp(Position position) {
        if (props.containsKey(position))    {
            props.get(position).removeFromUI(ui, position);
            props.remove(position);
        }
    }
}
