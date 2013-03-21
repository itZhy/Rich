package prop;

import player.Position;
import player.Role;

import java.util.HashMap;
import java.util.Map;

class PlayerPosition {
    private final Map<Role, Position> positions = new HashMap<Role, Position>();

    public void record(Role role, Position position) {
        positions.put(role, position);
    }

    public Boolean hasPlayer(Position position) {
        return positions.values().contains(position);
    }
}
