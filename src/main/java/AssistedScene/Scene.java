package AssistedScene;

import Player.Movement;

public interface Scene {
    public void handle(String roleName, Movement movement);
}
