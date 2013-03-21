package estate;

import player.Role;
import player.Position;
import ui.CommandLine;

public abstract class Deal {
    final EstateMap estateMap;
    final Bank bank;

    Deal(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public abstract void handle(Position position, Role role);

    boolean isAgree(String promptMessage) {
        do {
            String input = new CommandLine().waitForInput(promptMessage);
            if ("Y".equals(input.toUpperCase())) {
                return true;
            }
            if ("N".equals(input.toUpperCase())) {
                return false;
            }
        } while (true);
    }
}
