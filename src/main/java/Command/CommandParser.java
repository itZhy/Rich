package Command;

import Application.SubSystem;
import Player.Rounder;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;


public class CommandParser {
    private final Map<String, Command> stringToCommands = new HashMap<String, Command>();

    public CommandParser(Rounder rounder, SubSystem subSystem) {
        stringToCommands.put("roll", new Roll(rounder));
        stringToCommands.put("quit", new Quit());
        stringToCommands.put("bomb", new Bomb(subSystem.getPropManager()));
        stringToCommands.put("block", new Block(subSystem.getPropManager()));
        stringToCommands.put("robot", new Robot(subSystem.getPropManager()));
        stringToCommands.put("sell", new Sell(subSystem.getEstateManager()));
        stringToCommands.put("selltool", new SellTool(subSystem.getPropManager()));
        stringToCommands.put("query", new Query(subSystem.getEstateManager(), subSystem.getPropManager()));
        stringToCommands.put("help", new Help());
    }

    public Command get(String name) {
        if (null == stringToCommands.get(name)) {
            throw new UIException("无法识别您所输入指令，请重新输入。");
        }
        return stringToCommands.get(name);
    }
}
