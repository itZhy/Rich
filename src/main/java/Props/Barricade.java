package Props;

import Player.Player;

public class Barricade implements Prop {
    public void handle(Player player)   {

    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass();
    }
}
