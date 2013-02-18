package AssistedScene;

import Player.Movement;
import Prop.PropManager;
import UI.CommandLine;

public class PointPool implements Scene {
    private final Integer point;
    private final PropManager propManager;

    public PointPool(int point, PropManager propManager) {
        this.point = point;
        this.propManager = propManager;
    }

    public void handle(String roleName, Movement movement) {
        showPromptMessage();
        propManager.add(roleName, point);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((PointPool) object).point);
    }

    private void showPromptMessage() {
        new CommandLine().showMessageInNewline(getPromptMessage());
    }

    private String getPromptMessage() {
        return "您获得了" + point.toString() + "道具点数。";
    }
}
