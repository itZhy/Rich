package Interaction;

import Command.CommandParser;
import Player.Rounder;
import UI.Map;

class Controller {
    private final Map map = new Map();
    private final Rounder rounder;
    private final CommandParser parser = new CommandParser();

    public Controller(String input) {
        rounder = new Rounder(input, map);
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
