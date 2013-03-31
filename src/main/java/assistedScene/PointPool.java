package assistedScene;

import player.Movement;
import player.Role;
import prop.Point;
import prop.PropManager;
import ui.CommandLine;

public class PointPool implements Scene {
    private final Point point;
    private final PropManager propManager;

    public PointPool(Point point, PropManager propManager) {
        this.point = point;
        this.propManager = propManager;
    }

    public void handle(Role role, Movement movement) {
        showPromptMessage(role);
        propManager.add(role, point);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((PointPool) object).point);
    }

    private void showPromptMessage(Role role) {
        new CommandLine().outputInNewline(getPromptMessage(role));
    }

    private String getPromptMessage(Role role) {
        return role + "获得了" + point + "道具点数。";
    }
}
