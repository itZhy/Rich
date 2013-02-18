package AssistedScene;

import Player.Movement;
import Props.PropManager;

public class PointPool implements Scene {
    private final int point;
    private final PropManager propManager;

    public PointPool(int point, PropManager propManager) {
        this.point = point;
        this.propManager = propManager;
    }

    public void handle(String roleName, Movement movement) {
        propManager.add(roleName, point);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point == ((PointPool) object).point;
    }
}
