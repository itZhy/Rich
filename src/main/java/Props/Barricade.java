package Props;

import Player.Role;
import UI.Observer;

public class Barricade extends Prop {
    public Barricade(Role role, Observer ui) {
        super(ui);
        element = role.getElement('#');
        price = 50;
    }

    public void handle(Role role)   {
    }
}
