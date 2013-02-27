package Estate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VipManager {
    private final Map<String, Vip> vips = new HashMap<String, Vip>();

    public void setVip(String account) {
        vips.put(account, new Vip());
    }

    public void pass(String account) {
        if(vips.containsKey(account)){
            vips.get(account).pass();
        }
        removeExpiredVips();
    }

    public boolean isVip(String account) {
        return (vips.containsKey(account));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                vips.equals(((VipManager) object).vips);
    }

    private void removeExpiredVips() {
        Iterator<Map.Entry<String, Vip>> it = vips.entrySet().iterator();
        while (it.hasNext()) {
            removeExpiredVip(it);
        }
    }

    private void removeExpiredVip(Iterator<Map.Entry<String, Vip>> it) {
        if (!it.next().getValue().isExpired()) {
            it.remove();
        }
    }
}
