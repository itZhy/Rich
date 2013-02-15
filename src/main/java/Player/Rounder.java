package Player;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private final List<Player> orderedPlayers = new ArrayList<Player>();
    private int currentIndex = 0;

    public Player getCurrentPlayer() {
        return orderedPlayers.get(currentIndex);
    }

    public void next() {
        ++currentIndex;
        currentIndex %= orderedPlayers.size();
    }

    public void add(Player player){
        orderedPlayers.add(player);
    }
}
