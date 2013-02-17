package Interaction;

import Command.CommandParser;
import Player.*;
import Props.Ownership;
import Props.PropsMap;
import Estate.Estate;
import UI.Map;
import Util.CommandSplitter;

class Controller {
    private final Map ui = new Map();
    private final PropsMap propsMap = new PropsMap(ui);
    private final Ownership ownership = new Ownership();
    private final Rounder rounder = new Rounder();
    private final CommandParser parser = new CommandParser(propsMap, ownership);

    public Controller(String players) {
        initializeRounder(players);
        ui.refresh();
    }

    public void initializeRounder(String players) {
        PlayerParser parser = new PlayerParser(getObservers());
        for (int index = 0; index != players.length(); ++index) {
            Role role = parser.get(players.charAt(index));
            rounder.add(role);
        }
    }

    public void handleCommand(String input) {
        CommandSplitter splitter = new CommandSplitter(input);
        parser.get(splitter.name()).execute(rounder.current(), splitter.argument());
        rounder.next();
        ui.refresh();
    }

    public String getPromptMessageForCurrentPlayer() {
        return rounder.current().getPromptMessage();
    }

    private Callback getObservers(){
        Callback callback = new Callback();
        callback.attachForwardedObservers(new Estate(ui));
        callback.attachForwardingObservers(new Monitor(ui));
        return callback;
    }
}