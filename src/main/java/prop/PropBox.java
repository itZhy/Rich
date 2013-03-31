package prop;

import com.google.common.collect.HashMultiset;
import utils.Checker;

import java.util.ArrayList;
import java.util.List;

class PropBox {
    private final List<Prop> props = new ArrayList<Prop>();

    public void add(Prop prop) {
        final int CAPACITY = 10;
        Checker.check(CAPACITY != props.size(), "您的道具背包已满，不能再购买道具。");
        props.add(prop);
    }

    public String query() {
        final HashMultiset<Prop> multiSet = HashMultiset.create();
        multiSet.addAll(props);
        return "道具：路障 " + multiSet.count(new Barricade()) +
                "个；炸弹 " + multiSet.count(new Bomb()) +
                "个；机器娃娃 " + multiSet.count(new Robot()) + "个";
    }

    public boolean remove(Prop prop) {
        return props.remove(prop);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                props.equals(((PropBox) object).props);
    }
}