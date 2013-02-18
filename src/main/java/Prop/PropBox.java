package Prop;

import UI.UIException;

import java.util.ArrayList;
import java.util.List;

public class PropBox {
    private static final int CAPACITY = 10;
    private List<Prop> props = new ArrayList<Prop>();

    public void add(Prop prop) {
        if (CAPACITY == props.size()) {
            throw new UIException("您的道具背包已满，不能再购买道具。");
        }
        props.add(prop);
    }

    public boolean remove(Prop prop) {
        return props.remove(prop);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                props.equals(((PropBox) object).props);
    }
}
