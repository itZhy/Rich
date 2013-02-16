package Props;

import Player.Role;

public class Bomb implements Prop {
    public int price() {
        return 50;
    }

    public void handle(Role role) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }
}
