package AssistedScene;

import Estate.Estate;
import Player.Movement;
import Prop.PropManager;

public class GiftHouse implements Scene {
    private final Estate estate;
    private final PropManager pro;

    public GiftHouse(PropManager propManager, Estate estate) {
        this.pro = propManager;
        this.estate = estate;
    }

    public void handle(String roleName, Movement movement) {

    }
}
