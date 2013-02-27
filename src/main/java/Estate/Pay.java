package Estate;

import Player.Position;
import UI.CommandLine;

public class Pay extends Deal {
    public Pay(EstateMap estateMap, Bank bank) {
        super(estateMap, bank);
    }

    public void handle(Position position, String roleName) {
        if (!bank.isVip(roleName)) {
            showPromptMessage("路过他人地产，留下" + estateMap.get(position).toll() + "元买路钱(>_<)");
            bank.withdraw(roleName, estateMap.get(position).toll());
        } else {
            showPromptMessage("福神附身，可免过路费");
        }
        bank.add(estateMap.get(position).owner, estateMap.get(position).toll());
    }

    private void showPromptMessage(String message) {
        new CommandLine().outputInNewline(message);
    }
}
