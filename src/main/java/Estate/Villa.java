package Estate;

import Player.Role;
import UI.Observer;

public class Villa extends Building {
    public Villa(Role role, Observer ui){
        super(role, ui);
    }

    public Building update() {
      return null;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                owner.equals(((Villa) object).owner) &&
                ui.equals(((Villa) object).ui);
    }
}
