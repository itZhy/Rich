package Player;

import UI.Observer;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private final List<Player> orderedPlayers = new ArrayList<Player>();
    private int currentIndex = 0;

    public Rounder(String players, Observer observer) {
        PlayerParser parser = new PlayerParser(observer);
        for (int index = 0; index != players.length(); ++index) {
            orderedPlayers.add(parser.get(players.charAt(index)));
        }
    }

    public Player getCurrentPlayer() {
        return orderedPlayers.get(currentIndex);
    }

    public void next() {
        ++currentIndex;
        currentIndex %= orderedPlayers.size();
    }
}
