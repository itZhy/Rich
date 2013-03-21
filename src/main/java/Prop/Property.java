package prop;

import application.GameException;
import ui.CommandLine;

class Property {
    private static final int MIN_PRICE = 30;
    private final PropBox box = new PropBox();
    private Integer point = 0;

    public void add(int point) {
        this.point += point;
    }

    public void buy(Prop prop) {
        checkPurchasingPower(prop);
        exchange(prop);
    }

    public void sell(Prop prop) {
        consume(prop);
        add(prop.price());
    }

    public void consume(Prop prop) {
        if (box.isRemoveFailed(prop)) {
            throw new GameException("您没有此道具，请重新输入。", GameException.NEED_RETRY);
        }
    }

    public String query() {
        return "点数： " + point.toString() + "点\n" + box.query();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((Property) object).point) &&
                box.equals(((Property) object).box);
    }

    private void exchange(Prop prop) {
        box.add(prop);
        point -= prop.price();
        showPromptMessage(prop);
    }

    private void showPromptMessage(Prop prop) {
        new CommandLine().outputInNewline("您已成功购买" + prop.name() + "道具。");
    }

    private void checkPurchasingPower(Prop prop) {
        if (point < MIN_PRICE) {
            throw new GameException(currentPoint() + "不足以购买任何道具。", GameException.NEED_NOT_RETRY);
        }

        if (prop.price() > point) {
            throw new GameException(currentPoint() + "不足以购买" + prop.name() + "道具。", GameException.NEED_RETRY);
        }
    }

    private String currentPoint() {
        return "你当前剩余点数为" + point.toString();
    }
}