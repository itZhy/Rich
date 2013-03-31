package estate;

import player.Position;
import player.Role;

public class Idle extends Deal {
    public Idle(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, Role role) {
    }
}
