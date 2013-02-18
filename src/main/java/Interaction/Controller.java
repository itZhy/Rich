package Interaction;

import AssistedScene.SceneManager;
import Command.CommandParser;
import Estate.Estate;
import Player.*;
import Prop.PropManager;
import UI.Map;
import UI.UIObserver;
import Util.CommandSplitter;

class Controller {
    private final UIObserver ui = new Map();
    private final Rounder rounder = new Rounder();
    private final PropManager propManager = new PropManager(ui);
    private final Estate estate = new Estate(ui);
    private final SceneManager sceneManager = new SceneManager(propManager, estate);
    private final CommandParser parser = new CommandParser(propManager, estate);

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
        callback.attachForwardedObservers(estate);
        callback.attachForwardingObservers(new Monitor(ui));
        callback.attachForwardingObservers(propManager);
        callback.attachForwardedObservers(sceneManager);
        return callback;
    }
}