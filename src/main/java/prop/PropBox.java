package prop;

import application.GameException;
import utils.Checker;

import java.util.ArrayList;
import java.util.List;

class PropBox {
    private static final int CAPACITY = 10;
    private final List<Prop> props = new ArrayList<Prop>();

    public void add(Prop prop) {
        Checker.check(CAPACITY != props.size(), "您的道具背包已满，不能再购买道具。");
        props.add(prop);
    }

    public String query() {
        return "道具：路障 " + count("路障") +
                "个；炸弹 " + count("炸弹") +
                "个；机器娃娃 " + count("机器娃娃") + "个";
    }

    public boolean isRemoveFailed(Prop prop) {
        return !props.remove(prop);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                props.equals(((PropBox) object).props);
    }

    private Integer count(String name) {
        int count = 0;
        for (Prop prop : props) {
            count = addedCount(count, name, prop);
        }
        return count;
    }

    private int addedCount(int count, String name, Prop prop) {
        if (prop.name().equals(name)) {
            ++count;
        }
        return count;
    }
}