package Interaction;

import Command.CommandParser;
import Estate.Estate;
import Player.*;
import Props.PropsManager;
import UI.Map;
import UI.UIObserver;
import Util.CommandSplitter;

class Controller {
    private final UIObserver ui = new Map();
    private final PropsManager propsManager = new PropsManager(ui);
    private final Rounder rounder = new Rounder();
    private final CommandParser parser = new CommandParser(propsManager);

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
        callback.attachForwardingObservers(propsManager);
        return callback;
    }
}