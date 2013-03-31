package command;

import com.google.common.collect.ImmutableMap;
import player.Player;
import prop.*;
import prop.Bomb;
import prop.Robot;
import utils.Checker;

public class SellTool implements Command {
    private final PropManager propManager;

    public SellTool(PropManager propManager) {
        this.propManager = propManager;
    }

    public void execute(Player player, int argument) {
        propManager.sell(player.role(), new PropFactory().get(argument));
    }

    private class PropFactory {
        private final ImmutableMap<Integer, Prop> props =
                ImmutableMap.of(1, new Barricade(), 2, new Robot(), 3, new Bomb());
        ;

        public Prop get(int argument) {
            Checker.check(props.containsKey(argument), "你选择的道具编号不存在，请重新输入1，2或3。");
            return props.get(argument);
        }
    }
}
