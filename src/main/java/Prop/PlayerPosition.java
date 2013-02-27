package Prop;

import Player.Position;

import java.util.HashMap;
import java.util.Map;

public class PlayerPosition {
    private final Map<String, Position> positions = new HashMap<String, Position>();

    public void record(String roleName, Position position) {
        positions.put(roleName, position);
    }

    public Boolean hasPlayer(Position position) {
        return positions.values().contains(position);
    }
}
