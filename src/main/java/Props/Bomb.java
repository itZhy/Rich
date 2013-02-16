package Props;

import Player.Position;
import Player.Role;
import UI.UIObserver;

public class Bomb extends Prop {
    public Bomb(Role role, UIObserver ui) {
        super(ui);
        element = role.getElement('@');
        price = 50;
    }

    public void handle(Position position, Role role) {
        role.moveToHospital();
    }
}
