package AssistedScene;

import Application.GameException;
import Estate.EstateManager;
import Prop.PropManager;
import UI.CommandLine;

import java.util.HashMap;
import java.util.Map;

public class GiftSelectorFactory {
    private final Map<String, Selector> selectors = new HashMap<String, Selector>();
    private final PropManager propManager;
    private final EstateManager estateManager;

    public GiftSelectorFactory(PropManager propManager, EstateManager estateManager) {
        this.propManager = propManager;
        this.estateManager = estateManager;
        selectors.put("1", new BonusSelector());
        selectors.put("2", new PointSelector());
        selectors.put("3", new MascotSelector());
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
        public void select(String roleName) {
            estateManager.bonus(roleName);
            showPromptMessage("恭喜您获得2000金钱。");
        }
    }

    private class PointSelector implements Selector {
        public void select(String roleName) {
            propManager.add(roleName, 200);
            showPromptMessage("恭喜您获得200点数。");
        }
    }

    private class MascotSelector implements Selector {
        public void select(String roleName) {
            estateManager.setVip(roleName);
            showPromptMessage("恭喜您获得5回合福神附体状态，福神附体期间免收过路费。");
        }
    }
}
