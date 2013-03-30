package prop;

import application.GameException;
import ui.CommandLine;

class Property {
    private final PropBox box = new PropBox();
    private Point point = new Point(0);

    public void add(Point point) {
        this.point.add(point);
    }

    public void buy(Prop prop) {
        point.checkPurchasingPower(prop.price());
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
        point.consume(prop.price());
        showPromptMessage(prop);
    }

    private void showPromptMessage(Prop prop) {
        new CommandLine().outputInNewline("您已成功购买" + prop.name() + "道具。");
    }


}