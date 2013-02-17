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

    public boolean consume(Prop prop) {
        return props.remove(prop);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                points == ((Property) object).points &&
                props.equals(((Property) object).props);
    }

    private void exchange(Prop prop) {
        props.add(prop);
        points -= prop.price();
    }
}