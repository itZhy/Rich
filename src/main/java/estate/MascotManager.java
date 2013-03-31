package estate;

import player.Role;
import utils.RoundCounter;

import java.util.HashMap;
import java.util.Map;

class MascotManager {
    private final Map<Role, RoundCounter> remainRoundsInEachRole = new HashMap<Role, RoundCounter>();

    public void setMascot(Role role) {
        initializeWhenNotExist(role);
        remainRoundsInEachRole.get(role).setMaxCount(5);
    }

    private void initializeWhenNotExist(Role role)   {
        if (!remainRoundsInEachRole.containsKey(role))    {
            remainRoundsInEachRole.put(role, new RoundCounter());
        }
    }

    public void update(Role role) {
        initializeWhenNotExist(role);
        remainRoundsInEachRole.get(role).pass();
    }

    public boolean hasMascot(Role role) {
        initializeWhenNotExist(role);
        return !remainRoundsInEachRole.get(role).isExceed();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                remainRoundsInEachRole.equals(((MascotManager) object).remainRoundsInEachRole);
    }
}
