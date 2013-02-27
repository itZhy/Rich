package Estate;

import Player.Position;

public class Sell extends Deal {
    public Sell(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, String roleName) {
        bank.add(roleName, estateMap.get(position).sellingPrice());
        estateMap.clearBuilding(position);
    }
}
