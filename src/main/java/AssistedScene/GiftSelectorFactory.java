package AssistedScene;

import Estate.Estate;
import Prop.PropManager;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;

public class GiftSelectorFactory {
    private final Map<String, Selector> selectors = new HashMap<String, Selector>();
    private final PropManager propManager;
    private final Estate estate;

    public GiftSelectorFactory(PropManager propManager, Estate estate) {
        this.propManager = propManager;
        this.estate = estate;
        selectors.put("1", new BonusSelector());
        selectors.put("2", new PointSelector());
        selectors.put("3", new MascotSelector());
        selectors.put("F", new Quit());
    }

    public Selector get(String input) {
        if (!selectors.containsKey(input)) {
            throw new UIException("您所选择的礼品不存在，请重新输入1，2或3。");
        }
        return selectors.get(input);
    }

    private class BonusSelector implements Selector {
        public void select(String roleName) {

        }
    }

    private class PointSelector implements Selector {
        public void select(String roleName) {
            propManager.add(roleName, 200);
        }
    }

    private class MascotSelector implements Selector {
        public void select(String roleName) {
            estate.setVip(roleName);
        }
    }
}
