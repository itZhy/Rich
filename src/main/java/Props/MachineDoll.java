package Props;

import Player.Role;

public class MachineDoll implements Prop {
    public int price()  {
        return 30;
    }

    public void handle(Role role)   {

    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass();
    }
}
