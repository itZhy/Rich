package Estate;

import Player.Position;
import UI.CommandLine;

public abstract class Deal {
    protected EstateMap estateMap;
    protected Bank bank;
    protected Position position;
    protected String roleName;

    public Deal(EstateMap estateMap, Bank bank) {
        this.estateMap = estateMap;
        this.bank = bank;
    }

    public Deal set(Position position, String role) {
        this.position = position;
        this.roleName = role;
        return this;
    }

    public boolean checkChoice(String promptMessage) {
        do {
            String input = new CommandLine().waitForInput("是否花费" + estateMap.get(position).price + "元" + promptMessage + "该地产?");
            if ("Y".equals(input.toUpperCase())) {
                return true;
            } else if ("N".equals(input.toUpperCase())) {
                return false;
            }
        } while (true);
    }

    public abstract void handle();
}
