package Props;

import Player.Position;
import Player.Role;
import UI.Element;
import UI.Observer;

public abstract class Prop {
    private final Observer ui;
    protected int price;
    protected Element element;

    public Prop(Observer ui) {
        this.ui = ui;
    }

    public int price() {
        return price;
    }

    public void addToUI(Position position) {
        ui.add(position, element);
    }

    public void removeFromUI(Position position) {
        ui.delete(position, element);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }

    public abstract void handle(Role role);
}
