package assistedScene;

import application.GameException;
import prop.Barricade;
import prop.Bomb;
import prop.PropManager;
import prop.Robot;

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
        selectors.put("f", new Quit());
    }

    public Selector get(String input) {
        if (!selectors.containsKey(input))  {
            throw new GameException("您所选择的道具不存在，请重新输入1，2或3。", GameException.NEED_RETRY);
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

    private class Quit implements Selector {
        public void select(String roleName) {
            throw new GameException("欢迎下次光临。", GameException.NEED_NOT_RETRY);
        }
    }
}
