package application;

import command.CommandFactory;
import command.Splitter;
import estate.Money;
import estate.Insolvency;
import player.PlayerParser;
import player.Rounder;
import ui.Map;
import ui.UIObserver;
import utils.Checker;

class Controller {
    private final Rounder rounder = new Rounder();
    private final UIObserver ui = new Map();
    private final SubSystem subSystem = new SubSystem(ui);
    private final CommandFactory commandFactory = new CommandFactory(rounder, subSystem);

    public Controller(String players) {
        initializeRounder(players);
        ui.refresh();
    }

    public void resetInitialMoney(String money) {
        try {
            subSystem.resetInitialMoney(new Money(Integer.parseInt(money)));
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
        return rounder.currentPrompt();
    }

    private void initializeRounder(String players) {
        Checker.check(!players.isEmpty(), "您尚未选择任何玩家，请重新输入。");
        PlayerParser parser = new PlayerParser(subSystem.getObservers());
        for (int index = 0; index != players.length(); ++index) {
            rounder.add(parser.get(players.charAt(index)));
        }
    }
}