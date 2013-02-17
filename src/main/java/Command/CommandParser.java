package Command;

import Props.Ownership;
import Props.PropsMap;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;


public class CommandParser {
    private final Map<String, Command> stringToCommands = new HashMap<String, Command>();

    public CommandParser(PropsMap propsMap, Ownership ownership) {
        stringToCommands.put("roll", new Roll());
        stringToCommands.put("quit", new Quit());
        stringToCommands.put("bomb", new Bomb(propsMap, ownership));
        stringToCommands.put("block", new Block(propsMap, ownership));
        stringToCommands.put("robot", new Robot(propsMap, ownership));
    }

    public Command get(String name) {
        if (null == stringToCommands.get(name)) {
            throw new UIException("无法识别您所输入指令，请重新输入。");
        }
        return stringToCommands.get(name);
    }
}
