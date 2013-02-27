package Estate;

import Player.Position;

public class DoNothing extends Deal {
    public DoNothing(EstateMap estateMap, Bank bank){
        super(estateMap, bank);
    }

    public void handle(Position position, String roleName) {
    }
}
