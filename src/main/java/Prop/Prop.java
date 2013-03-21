package prop;

import player.Movement;
import player.Position;
import ui.Element;
import ui.UIObserver;

public abstract class Prop {
    String name;
    int price;
    Element element;

    public String name() {
        return name;
    }

    public int price() {
        return price;
    }

    public void addToUI(UIObserver ui, Position position) {
        ui.add(position, element);
        ui.refresh();
    }

    public void removeFromUI(UIObserver ui, Position position) {
        ui.delete(position, element);
        ui.refresh();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }

    public abstract void handle(Movement movement);
}
