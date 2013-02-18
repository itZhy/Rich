package Prop;

import UI.UIException;

public class Property {
    private int points = 0;
    private PropBox box = new PropBox();

    public void add(int point) {
        points += point;
    }

    public void buy(Prop prop) {
        if (prop.price() > points) {
            throw new UIException("您的点数不足，不能购买此道具。", UIException.NEED_NOT_RETRY);
        }
        exchange(prop);
    }

    public void consume(Prop prop) {
        if (!box.remove(prop))  {
            throw new UIException("您没有此道具，请重新输入。");
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                points == ((Property) object).points &&
                box.equals(((Property) object).box);
    }

    private void exchange(Prop prop) {
        box.add(prop);
        points -= prop.price();
    }
}