package Estate;

import Player.Position;

public class Idle extends Deal {
    public Idle(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, String roleName) {
    }
}