package assistedScene;

import application.GameException;
import com.google.common.collect.ImmutableMap;
import player.Role;
import prop.Barricade;
import prop.Bomb;
import prop.PropManager;
import prop.Robot;

public class PropSelectorFactory {
    private final ImmutableMap<String, Selector> selectors;
    private final PropManager propManager;

    public PropSelectorFactory(PropManager propManager) {
        this.propManager = propManager;
        selectors = ImmutableMap.of(
                "1", new BarricadeSelector(), "2", new RobotSelector(), "3", new BombSelector(), "f", new Quit());
    }

    public Selector get(String input) {
        if (!selectors.containsKey(input)) {
            throw new GameException("您所选择的道具不存在，请重新输入1，2或3。", GameException.NEED_RETRY);
        }
        return selectors.get(input);
    }

    private class BarricadeSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Barricade(role));
        }
    }

    private class RobotSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Robot());
        }
    }

    private class BombSelector implements Selector {
        public void select(Role role) {
            propManager.buy(role, new Bomb(role));
        }
    }

    private class Quit implements Selector {
        public void select(Role role) {
            throw new GameException("欢迎下次光临。", GameException.NEED_NOT_RETRY);
        }
    }
}
