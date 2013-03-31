package estate;

import player.Position;
import player.Role;

public class Update extends Deal {
    public Update(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, Role role) {
        if (isAgree("是否花费" + estateMap.get(position).basePrice + "元升级该地产？Y：是，N：否")) {
            estateMap.update(position, role);
            bank.withdraw(estateMap.get(position).owner, estateMap.get(position).basePrice);
        }
    }
}
