package prop;

import player.Movement;
import player.Position;
import player.Role;
import ui.Element;
import ui.UIObserver;

public abstract class Prop {
    Element element;

    public abstract Point price();

    public abstract void handle(Movement movement);

    public void addToUI(Role role, UIObserver ui, Position position) {
        ui.add(position, role.dye(element));
        ui.refresh();
    }

    public void removeFromUI(Role role, UIObserver ui, Position position) {
        ui.delete(position, role.dye(element));
        ui.refresh();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && toString().equals(object.toString());
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
