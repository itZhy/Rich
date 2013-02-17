package Interaction;

import Command.CommandParser;
import Estate.Estate;
import Player.*;
import UI.Map;
import Util.CommandSplitter;

class Controller {
    private final Map map = new Map();
    private final Estate estate = new Estate(map);
    private final Rounder rounder = new Rounder();
    private final CommandParser parser = new CommandParser();

    public Controller(String players) {
        initializeRounderAndBank(players);
        map.display();
    }

    public void initializeRounderAndBank(String players) {
        PlayerParser parser = new PlayerParser(map, setObservers());
        for (int index = 0; index != players.length(); ++index) {
            Role role = parser.get(players.charAt(index));
            rounder.add(role);
            estate.add(role.getClass().toString());
        }
    }

    public void handleCommand(String input) {
        CommandSplitter splitter = new CommandSplitter(input);
        parser.get(splitter.name()).execute(rounder.current(), splitter.argument());
        rounder.next();
        map.display();
    }

    public String getPromptMessageForCurrentPlayer() {
        return rounder.current().getPromptMessage();
    }

    private Callback setObservers(){
        Callback callback = new Callback();
        callback.attach(estate);
        return callback;
    }
}
