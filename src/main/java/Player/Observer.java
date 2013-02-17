package Player;

import Player.Position;

public interface Observer {
    public void handle(Position position, String name);
}
