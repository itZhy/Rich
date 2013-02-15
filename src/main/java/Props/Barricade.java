package Props;

import Player.Role;

public class Barricade implements Prop {
    public void handle(Role role)   {
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass();
    }
}
