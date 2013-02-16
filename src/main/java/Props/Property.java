package Props;

import java.util.ArrayList;
import java.util.List;

public class Property {
    private int points = 0;
    private List<Prop> props = new ArrayList<Prop>();

    public void add(int point) {
        points += point;
    }

    public boolean buy(Prop prop) {
        if (prop.price() <= points) {
            exchange(prop);
            return true;
        }
        return false;
    }

    private void exchange(Prop prop) {
        props.add(prop);
        points -= prop.price();
    }

    public boolean consume(Prop prop) {
        return props.remove(prop);
    }
}
