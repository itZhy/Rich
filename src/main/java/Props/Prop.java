package Props;

import Player.Movement;
import Player.Position;
import UI.Element;
import UI.UIObserver;

public abstract class Prop {
    protected int price;
    protected Element element;

    public String name()    {
        return getClass().toString();
    }

    public int price() {
        return price;
    }

    public void addToUI(UIObserver ui, Position position) {
        ui.add(position, element);
    }

    public void removeFromUI(UIObserver ui, Position position) {
        ui.delete(position, element);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }

    public abstract void handle(Movement movement);
}
