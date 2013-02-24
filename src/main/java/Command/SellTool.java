package Command;

import Player.Role;
import Prop.*;
import Prop.Bomb;
import Prop.Robot;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;

public class SellTool implements Command {
    private final PropManager propManager;

    public SellTool(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Role role, int argument) {
        propManager.sell(role.name(), new PropFactory(role.name()).get(argument));
    }

    private class PropFactory {
        private final Map<Integer, Prop> props = new HashMap<Integer, Prop>();

        public PropFactory(String owner) {
            props.put(1, new Barricade(owner));
            props.put(2, new Robot());
            props.put(3, new Bomb(owner));
        }

        public Prop get(int argument) {
            if (!props.containsKey(argument)) {
                throw new UIException("你选择的道具编号不存在，请重新输入1，2或3。");
            }
            return props.get(argument);
        }
    }
}
