package assistedScene;

import player.Movement;
import player.Role;

public interface Scene {
    public void handle(Role role, Movement movement);
}
