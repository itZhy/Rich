package assistedScene;

import application.GameException;
import com.google.common.collect.ImmutableMap;
import estate.EstateManager;
import player.Role;
import prop.Point;
import prop.PropManager;
import ui.CommandLine;

public class GiftSelectorFactory {
    private final ImmutableMap<String, Selector> selectors;
    private final PropManager propManager;
    private final EstateManager estateManager;

    public GiftSelectorFactory(PropManager propManager, EstateManager estateManager) {
        this.propManager = propManager;
        this.estateManager = estateManager;
        selectors = ImmutableMap.of("1", new BonusSelector(), "2", new PointSelector(), "3", new MascotSelector());
    }

    public Selector get(String input) {
        if (!selectors.containsKey(input)) {
            throw new GameException("您所选择的礼品不存在，记得下次输入1，2或3。", GameException.NEED_RETRY);
        }
        return selectors.get(input);
    }

    private void showPromptMessage(String message) {
        new CommandLine().outputInNewline(message);
    }

    private class BonusSelector implements Selector {
        public void select(Role role) {
            estateManager.bonus(role);
            showPromptMessage("恭喜您获得2000金钱。");
        }
    }

    private class PointSelector implements Selector {
        public void select(Role role) {
            propManager.add(role, new Point(200));
            showPromptMessage("恭喜您获得200点数。");
        }
    }

    private class MascotSelector implements Selector {
        public void select(Role role) {
            estateManager.setVip(role);
            showPromptMessage("恭喜您获得5回合福神附体状态，福神附体期间免收过路费。");
        }
    }
}
