package Prop;

import UI.CommandLine;
import UI.UIException;

public class Property {
    private static final int MIN_PRICE = 30;
    private Integer point = 0;
    private PropBox box = new PropBox();

    public void add(int point) {
        this.point += point;
    }

    public void buy(Prop prop) {
        checkPurchasingPower();
        if (prop.price() > point) {
            throw new UIException(currentPoint() + "不足以购买" + prop.name() + "道具。");
        }
        exchange(prop);
    }

    public void consume(Prop prop) {
        if (!box.remove(prop)) {
            throw new UIException("您没有此道具，请重新输入。");
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point == ((Property) object).point &&
                box.equals(((Property) object).box);
    }

    private void exchange(Prop prop) {
        box.add(prop);
        point -= prop.price();
        showPromptMessage(prop);
    }

    private void showPromptMessage(Prop prop) {
        new CommandLine().output("您已成功购买" + prop.name() + "道具。");
    }

    private void checkPurchasingPower() {
        if (point < MIN_PRICE) {
            throw new UIException(currentPoint() + "不足以购买任何道具。", UIException.NEED_NOT_RETRY);
        }
    }

    private String currentPoint() {
        return "你当前剩余点数为" + point.toString();
    }
}