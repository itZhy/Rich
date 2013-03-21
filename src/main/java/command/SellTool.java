package command;

import application.GameException;
import player.Role;
import player.Player;
import prop.*;
import prop.Bomb;
import prop.Robot;

import java.util.HashMap;
import java.util.Map;

public class SellTool implements Command {
    private final PropManager propManager;

    public SellTool(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Player player, int argument) {
        propManager.sell(player.role(), new PropFactory(player.role()).get(argument));
    }

    private class PropFactory {
        private final Map<Integer, Prop> props = new HashMap<Integer, Prop>();

        public PropFactory(Role owner) {
            props.put(1, new Barricade(owner));
            props.put(2, new Robot());
            props.put(3, new Bomb(owner));
        }

        public Prop get(int argument) {
            if (!props.containsKey(argument)) {
                throw new GameException("你选择的道具编号不存在，请重新输入1，2或3。", GameException.NEED_RETRY);
            }
            return props.get(argument);
        }
    }
}
