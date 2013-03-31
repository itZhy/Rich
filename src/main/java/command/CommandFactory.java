package command;

import application.SubSystem;
import com.google.common.collect.ImmutableMap;
import player.Rounder;
import utils.Checker;

public class CommandFactory {
    private final ImmutableMap<String, Command> stringToCommands;

    public CommandFactory(Rounder rounder, SubSystem subSystem) {
        stringToCommands = ImmutableMap.<String, Command>builder()
                .put("roll", new Roll(rounder))
                .put("help", new Help())
                .put("bomb", new Bomb(subSystem.getPropManager()))
                .put("block", new Block(subSystem.getPropManager()))
                .put("robot", new Robot(subSystem.getPropManager()))
                .put("sell", new Sell(subSystem.getEstateManager()))
                .put("query", new Query(subSystem.getEstateManager(), subSystem.getPropManager()))
                .put("selltool", new SellTool(subSystem.getPropManager())).build();
    }

    public Command get(String name) {
        Checker.check(stringToCommands.containsKey(name), "无法识别您所输入指令，请重新输入。");
        return stringToCommands.get(name);
    }
}
