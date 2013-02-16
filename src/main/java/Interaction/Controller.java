package Interaction;

import Command.CommandParser;
import Estate.Estate;
import Player.PlayerParser;
import Player.Role;
import Player.Rounder;
import UI.Map;

class Controller {
    private final Map map = new Map();
    private final Rounder rounder = new Rounder();
    private final Estate estate = new Estate();
    private final CommandParser parser = new CommandParser();

    public Controller(String players) {
        initializeRounderAndBank(players);
        map.display();
    }

    public void initializeRounderAndBank(String players){
        PlayerParser parser = new PlayerParser(map);
        for (int index = 0; index != players.length(); ++index) {
            Role role = parser.get(players.charAt(index));
            rounder.add(role);
            estate.add(role.getClass().toString());
        }
    }

    public void handleCommand(String input) {
        parser.get(input).execute(rounder.current());
        rounder.next();
        map.display();
    }

    public String getPromptMessageForCurrentPlayer() {
        return rounder.current().getPromptMessage();
    }
}
