package Estate;

import java.util.HashMap;
import java.util.Map;

public class VipManager {
    private final Map<String, Vip> vips = new HashMap<String, Vip>();

    public void setVip(String account) {
        initializeWhenNotExist(account);
        vips.get(account).set();
    }

    public void pass() {
        for (Vip vip : vips.values()) {
            vip.pass();
        }
    }

    public boolean vipStatus(String account) {
        initializeWhenNotExist(account);
        return vips.get(account).vipStatus();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                vips.equals(((VipManager) object).vips);
    }

    private void initializeWhenNotExist(String account) {
        if (!vips.containsKey(account)) {
            vips.put(account, new Vip());
        }
    }
}
