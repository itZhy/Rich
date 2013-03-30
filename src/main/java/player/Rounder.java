package player;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private final List<Player> orderedPlayers = new ArrayList<Player>();
    private int currentIndex = 0;

    public Player currentPlayer() {
        return orderedPlayers.get(currentIndex);
    }

    public void nextPlayer() {
        do {
            currentPlayer().pass();
            next();
        } while (currentPlayer().isNeedSkip());
    }

    private void next() {
        ++currentIndex;
        currentIndex %= orderedPlayers.size();
    }

    public void add(Player player) {
        orderedPlayers.add(player);
    }

    public boolean isOnlyOnePlayerAfterEliminate(Role role) {
        for (Player player : orderedPlayers) {
            if (player.role().equals(role)) {
                return isOnlyOnePlayerAfterDelete(player);
            }
        }
        return false;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                orderedPlayers.equals(((Rounder) object).orderedPlayers) &&
                currentIndex == ((Rounder) object).currentIndex;
    }

    private boolean isOnlyOnePlayerAfterDelete(Player player) {
        player.leave();
        orderedPlayers.remove(player);
        currentIndex %= orderedPlayers.size();
        return 1 == orderedPlayers.size();
    }
}
