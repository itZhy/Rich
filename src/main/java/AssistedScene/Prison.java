package AssistedScene;

import Player.Movement;

public class Prison implements Scene {
    public void handle(String roleName, Movement movement) {
        movement.block(2);
    }
}
