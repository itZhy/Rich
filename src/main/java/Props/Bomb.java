package Props;

import Player.Position;
import Player.Role;
import UI.Observer;

public class Bomb extends Prop {
    public Bomb(Role role, Observer ui) {
        super(ui);
        element = role.getElement('@');
        price = 50;
    }

    public void handle(Role role) {
        role.moveToHospital();
    }
}
