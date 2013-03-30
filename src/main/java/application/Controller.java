package application;

import command.CommandFactory;
import command.Splitter;
import estate.Insolvency;
import player.PlayerParser;
import player.Rounder;
import ui.Map;
import ui.UIObserver;

class Controller {
    private final Rounder rounder = new Rounder();
    private final UIObserver ui = new Map();
    private final SubSystem subSystem = new SubSystem(ui);
    private final CommandFactory commandFactory = new CommandFactory(rounder, subSystem);

    public Controller(String players) {
        initializeRounder(players);
        ui.refresh();
    }

    public void initialFund(String fund) {
        try {
            subSystem.getEstateManager().setInitialFund(Integer.parseInt(fund));
        } catch (java.lang.NumberFormatException e) {
            throw new GameException("输入金额有误。");
        }
    }

    public void handleCommand(String input) {
        try {
            Splitter splitter = new Splitter(input);
            commandFactory.get(splitter.name()).execute(rounder.currentPlayer(), splitter.argument());
        } catch (Insolvency e) {
            e.handle(subSystem.getEstateManager(), rounder);
        }
    }

    public String getPrompt() {
        return rounder.currentPlayer().role().toString() + ">";
    }

    private void initializeRounder(String players) {
        checkInputPlayers(players);
        PlayerParser parser = new PlayerParser(subSystem.getObservers());
        for (int index = 0; index != players.length(); ++index) {
            rounder.add(parser.get(players.charAt(index)));
        }
    }

    private void checkInputPlayers(String players) {
        if (players.isEmpty()) {
            throw new GameException("您尚未选择任何玩家，请重新输入。");
        }
    }
}