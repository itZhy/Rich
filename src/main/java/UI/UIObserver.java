package UI;

import Player.Position;

public interface UIObserver {
    public void add(Position position, Element element);
    public void delete(Position position, Element element);
    public void move(Position source, Position destination, Element element);
    public void replace(Position position, Element element);
}