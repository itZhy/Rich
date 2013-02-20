package AssistedScene;

import Estate.EstateManager;
import Player.Movement;
import Prop.PropManager;

public class GiftHouse implements Scene {
    private final EstateManager estateManager;
    private final PropManager pro;

    public GiftHouse(PropManager propManager, EstateManager estateManager) {
        this.pro = propManager;
        this.estateManager = estateManager;
    }

    public void handle(String roleName, Movement movement) {

    }
}
