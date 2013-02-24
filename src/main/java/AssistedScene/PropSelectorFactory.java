package AssistedScene;

import Prop.Barricade;
import Prop.Bomb;
import Prop.PropManager;
import Prop.Robot;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;

public class PropSelectorFactory {
    private final Map<String, Selector> selectors = new HashMap<String, Selector>();
    private final PropManager propManager;

    public PropSelectorFactory(PropManager propManager) {
        this.propManager = propManager;
        selectors.put("1", new BarricadeSelector());
        selectors.put("2", new RobotSelector());
        selectors.put("3", new BombSelector());
        selectors.put("F", new Quit());
    }

    public Selector get(String input) {
        if (!selectors.containsKey(input))  {
            throw new UIException("您所选择的道具不存在，请重新输入1，2或3。");
        }
        return selectors.get(input);
    }

    private class BarricadeSelector implements Selector {
        public void select(String roleName) {
            propManager.buy(roleName, new Barricade(roleName));
        }
    }

    private class RobotSelector implements Selector {
        public void select(String roleName) {
            propManager.buy(roleName, new Robot());
        }
    }

    private class BombSelector implements Selector {
        public void select(String roleName) {
            propManager.buy(roleName, new Bomb(roleName));
        }
    }
}
