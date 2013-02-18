package Command;

import Prop.PropManager;
import UI.UIException;

import java.util.HashMap;
import java.util.Map;


public class CommandParser {
    private final Map<String, Command> stringToCommands = new HashMap<String, Command>();

    public CommandParser(PropManager propManager) {
        stringToCommands.put("roll", new Roll());
        stringToCommands.put("quit", new Quit());
        stringToCommands.put("bomb", new Bomb(propManager));
        stringToCommands.put("block", new Block(propManager));
        stringToCommands.put("robot", new Robot(propManager));
    }

    public Command get(String name) {
        if (null == stringToCommands.get(name)) {
            throw new UIException("无法识别您所输入指令，请重新输入。");
        }
        return stringToCommands.get(name);
    }
}
