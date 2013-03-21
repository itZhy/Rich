package estate;

import player.Role;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class VipManager {
    private final Map<Role, Vip> vips = new HashMap<Role, Vip>();

    public void setVip(Role role) {
        vips.put(role, new Vip());
    }

    public void pass(Role role) {
        if (vips.containsKey(role)) {
            vips.get(role).pass();
        }
        removeExpiredVips();
    }

    public boolean isVip(Role role) {
        return (vips.containsKey(role));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                vips.equals(((VipManager) object).vips);
    }

    private void removeExpiredVips() {
        Iterator<Map.Entry<Role, Vip>> it = vips.entrySet().iterator();
        while (it.hasNext()) {
            removeExpiredVip(it);
        }
    }

    private void removeExpiredVip(Iterator<Map.Entry<Role, Vip>> it) {
        if (it.next().getValue().isExpired()) {
            it.remove();
        }
    }
}
