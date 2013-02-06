package UI;

import Player.Position;

public interface UIObserver {
    public void update(Position position, Element element);

    public Element get(Position position);
}
