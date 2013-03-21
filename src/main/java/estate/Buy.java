package estate;

import player.Role;
import player.Position;

public class Buy extends Deal {
    public Buy(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, Role role) {
        if (isAgree("是否花费" + estateMap.get(position).basePrice + "元购买该地产？Y：是，N：否")) {
            estateMap.update(position, role);
            bank.withdraw(role, estateMap.get(position).basePrice);
        }
    }
}
