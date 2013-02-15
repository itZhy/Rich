package Props;

import Player.Position;

import java.util.HashMap;
import java.util.Map;

public class PropsMap {
    private final Map<Position, Prop> props = new HashMap<Position, Prop>();
    private static final int CLEAN_RANGE = 10;

    public void put(Position position, Prop prop) {
        props.put(position, prop);
    }

    public void cleanTheFront(Position position) {
        for (int step = 1; step <= CLEAN_RANGE; ++step)  {
            props.remove(position.move(step));
        }
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() && props.equals(((PropsMap)object).props);
    }
}
