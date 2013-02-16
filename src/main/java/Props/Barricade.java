package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class Barricade extends Prop {
    public Barricade(Role role, UIObserver ui) {
        super(ui);
        element = role.getElement('#');
        price = 50;
    }

    public void handle(Position position, Role role)   {
        role.block();
    }
}
