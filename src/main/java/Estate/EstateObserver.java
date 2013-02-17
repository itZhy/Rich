package Estate;

import Player.Position;

public interface EstateObserver {
    public void handle(Position position, String name);
}
