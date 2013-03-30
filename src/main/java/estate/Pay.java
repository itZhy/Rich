package estate;

import player.Role;
import player.Position;
import ui.CommandLine;

public class Pay extends Deal {
    public Pay(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, Role role) {
        if (bank.isVip(role)) {
            showPromptMessage("福神附身，可免过路费");
            return;
        }
        pay(position, role);
    }

    private void pay(Position position, Role roleName) {
        showPromptMessage("路过他人地产，留下" + estateMap.get(position).toll() + "元过路费。");
        bank.withdraw(roleName, estateMap.get(position).toll());
        bank.add(estateMap.get(position).owner, estateMap.get(position).toll());
    }

    private void showPromptMessage(String message) {
        new CommandLine().outputInNewline(message);
    }
}
