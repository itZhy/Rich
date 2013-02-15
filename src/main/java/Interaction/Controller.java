package Interaction;

import Command.CommandParser;
import Estate.Bank;
import Player.PlayerParser;
import Player.Player;
import Player.Rounder;
import UI.Map;

class Controller {
    private final Map map = new Map();
    private final Rounder rounder = new Rounder();
    private final Bank bank = new Bank();
    private final CommandParser parser = new CommandParser();

    public Controller(String players) {
        PlayerParser parser = new PlayerParser(map);
        for (int index = 0; index != players.length(); ++index) {
            Player player = parser.get(players.charAt(index));
            rounder.add(player);
            bank.add(player.getClass().toString());
        }

        map.display();
    }

    public void handleCommand(String input) {
        parser.get(input).execute(rounder.getCurrentPlayer());
        rounder.next();
        map.display();
    }

    public String getPromptMessageForCurrentPlayer() {
        return rounder.getCurrentPlayer().getPromptMessage();
    }
}
