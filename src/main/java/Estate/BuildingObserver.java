package Estate;

import Player.Position;
import org.fusesource.jansi.Ansi;

public interface BuildingObserver {
    public void handle(Position position, String name, Ansi.Color color);
}
