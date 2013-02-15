package Props;

import Player.Player;

public class Bomb implements Prop {
    public void handle(Player player) {
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass();
    }
}
