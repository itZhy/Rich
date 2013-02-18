package AssistedScene;

import Player.Movement;
import Props.PropsManager;

public class PointsPool implements Scene {
    private final int point;
    private final PropsManager propsManager;

    public PointsPool(int point, PropsManager propsManager) {
        this.point = point;
        this.propsManager = propsManager;
    }

    public void handle(String roleName, Movement movement) {
        propsManager.add(roleName, point);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point == ((PointsPool) object).point;
    }
}
