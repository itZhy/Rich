package assistedScene;

import player.Movement;

public interface Scene {
    public void handle(String roleName, Movement movement);
}
