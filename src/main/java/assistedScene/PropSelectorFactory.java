package assistedScene;

import com.google.common.collect.ImmutableMap;
import player.Role;
import prop.Barricade;
import prop.Bomb;
import prop.PropManager;
import prop.Robot;
import utils.Checker;

public class PropSelectorFactory {
    private final ImmutableMap<String, Selector> selectors;
    private final PropManager propManager;

    public PropSelectorFactory(PropManager propManager) {
        this.propManager = propManager;
        selectors = ImmutableMap.of(
                "1", new BarricadeSelector(), "2", new RobotSelector(), "3", new BombSelector());
    }

    public Selector get(String input) {
        Checker.check(selectors.containsKey(input), "您所选择的道具不存在，请重新输入1，2或3。");
        return selectors.get(input);
    }

    private class BarricadeSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Barricade());
        }
    }

    private class RobotSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Robot());
        }
    }

    private class BombSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Bomb());
        }
    }
}
