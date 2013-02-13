package Command;

import Interaction.Exception;

import java.util.HashMap;
import java.util.Map;

public class CommandParser {
    private Map<String, Command> stringToCommands = new HashMap<String, Command>();

    public CommandParser() {
        stringToCommands.put("roll", new Roll());
    }

    public Command get(String name) {
        if (null == stringToCommands.get(name)) {
            throw new Exception("无法识别您所输入指令，请重新输入。");
        }
        return stringToCommands.get(name);
    }
}
