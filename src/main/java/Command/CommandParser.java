package Command;

import Props.Ownership;
import Props.PropsManager;
import Props.PropsMap;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;


public class CommandParser {
    private final Map<String, Command> stringToCommands = new HashMap<String, Command>();

    public CommandParser(PropsManager propsManager) {
        stringToCommands.put("roll", new Roll());
        stringToCommands.put("quit", new Quit());
        stringToCommands.put("bomb", new Bomb(propsManager));
        stringToCommands.put("block", new Block(propsManager));
        stringToCommands.put("robot", new Robot(propsManager));
    }

    public Command get(String name) {
        if (null == stringToCommands.get(name)) {
            throw new UIException("无法识别您所输入指令，请重新输入。");
        }
        return stringToCommands.get(name);
    }
}
