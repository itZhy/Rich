package Estate;

import Player.Position;
import UI.CommandLine;

public class Pay extends Deal {
    public Pay(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, String roleName) {
        if (bank.isVip(roleName)) {
            showPromptMessage("福神附身，可免过路费");
            return;
        }

        pay(position, roleName);
    }

    private void pay(Position position, String roleName) {
        showPromptMessage("路过他人地产，留下" + estateMap.get(position).toll() + "元过路费。");
        bank.withdraw(roleName, estateMap.get(position).toll());
        bank.add(estateMap.get(position).owner, estateMap.get(position).toll());
    }

    private void showPromptMessage(String message) {
        new CommandLine().outputInNewline(message);
    }
}
