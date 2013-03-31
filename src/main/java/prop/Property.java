package prop;

import ui.CommandLine;
import utils.Checker;

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
        Checker.check(!box.isRemoveFailed(prop), "您没有此道具，请重新输入。");
    }

    public String query() {
        return "点数： " + point + "点\n" + box.query();
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