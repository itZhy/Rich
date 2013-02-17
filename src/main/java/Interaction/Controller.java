package Interaction;

import Command.CommandParser;
import Estate.Estate;
import Player.Callback;
import Player.PlayerParser;
import Player.Role;
import Player.Rounder;
import Props.Ownership;
import Props.PropsMap;
import UI.Map;
import Util.CommandSplitter;

class Controller {
    private final Map ui = new Map();
    private final PropsMap propsMap = new PropsMap(ui);
    private final Ownership ownership = new Ownership();
    private final Rounder rounder = new Rounder();
    private final Estate estate = new Estate(ui);
    private final CommandParser parser = new CommandParser(propsMap, ownership);

    public Controller(String players) {
        initializeRounderAndBank(players);
        ui.display();
    }

    public void initializeRounderAndBank(String players) {
        PlayerParser parser = new PlayerParser(ui, setObservers());
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
        ui.display();
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
