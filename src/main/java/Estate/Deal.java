package Estate;

import Player.Position;
import UI.CommandLine;

public abstract class Deal {
    protected EstateMap estateMap;
    protected Bank bank;

    public Deal(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public abstract void handle(Position position, String role);

    protected boolean isAgree(String promptMessage) {
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
