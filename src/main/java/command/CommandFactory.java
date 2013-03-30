package command;

import application.GameException;
import application.SubSystem;
import com.google.common.collect.ImmutableMap;
import player.Rounder;

public class CommandFactory {
    private final ImmutableMap<String, Command> stringToCommands;

    public CommandFactory(Rounder rounder, SubSystem subSystem) {
        stringToCommands = ImmutableMap.<String, Command>builder().put("roll", new Roll(rounder))
                .put("quit", new Quit()).put("help", new Help())
                .put("bomb", new Bomb(subSystem.getPropManager()))
                .put("block", new Block(subSystem.getPropManager()))
                .put("robot", new Robot(subSystem.getPropManager()))
                .put("sell", new Sell(subSystem.getEstateManager()))
                .put("selltool", new SellTool(subSystem.getPropManager()))
                .put("query", new Query(subSystem.getEstateManager(), subSystem.getPropManager())).build();
    }

    public Command get(String name) {
        if (!stringToCommands.containsKey(name)) {
            throw new GameException("无法识别您所输入指令，请重新输入。", GameException.NEED_RETRY);
        }
        return stringToCommands.get(name);
    }
}
