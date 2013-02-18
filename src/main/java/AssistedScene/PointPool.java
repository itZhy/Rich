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
        showPromptMessage(roleName);
        propManager.add(roleName, point);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((PointPool) object).point);
    }

    private void showPromptMessage(String roleName) {
        new CommandLine().outputInNewline(getPromptMessage(roleName));
    }

    private String getPromptMessage(String roleName) {
        return roleName + "获得了" + point.toString() + "道具点数。";
    }
}
