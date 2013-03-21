package player;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private final List<Player> orderedPlayers = new ArrayList<Player>();
    private int currentIndex = 0;

    public Player current() {
        return orderedPlayers.get(currentIndex);
    }

    public void next() {
        do {
            ++currentIndex;
            currentIndex %= orderedPlayers.size();
        } while (current().skip());
    }

    public void add(Player player) {
        orderedPlayers.add(player);
    }

    public boolean isOnlyOneRoleAfterEliminate(Role role) {
        for (Player player : orderedPlayers) {
            if (player.role().equals(role)) return isOnlyOneRoleAfterDelete(player);
        }
        return false;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                orderedPlayers.equals(((Rounder) object).orderedPlayers) &&
                currentIndex == ((Rounder) object).currentIndex;
    }

    private boolean isOnlyOneRoleAfterDelete(Player player) {
        player.leave();
        orderedPlayers.remove(player);
        currentIndex %= orderedPlayers.size();
        return 1 == orderedPlayers.size();
    }
}
