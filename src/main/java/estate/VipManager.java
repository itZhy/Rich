package estate;

import player.Role;
import utils.RoundCounter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class VipManager {
    private final Map<Role, RoundCounter> vips = new HashMap<Role, RoundCounter>();

    public void setVip(Role role) {
        initializeWhenNotExist(role);
        vips.get(role).setMaxCount(5);
    }

    private void initializeWhenNotExist(Role role)   {
        if (!vips.containsKey(role))    {
            vips.put(role, new RoundCounter());
        }
    }

    public void pass(Role role) {
        initializeWhenNotExist(role);
        vips.get(role).pass();
    }

    public boolean isVip(Role role) {
        initializeWhenNotExist(role);
        return !vips.get(role).isExceed();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                vips.equals(((VipManager) object).vips);
    }
}
