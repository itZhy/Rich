package Estate;

import Player.Position;
import org.fusesource.jansi.Ansi;

public interface EstateObserver {
    public void handle(Position position, String name, Ansi.Color color);
}
