package Command;


import Player.Player;

import java.util.HashMap;
import java.util.Map;

public class Invoker {
    private Command command;
    private Map<String, Command> stringToCommand = new HashMap<String, Command>();

    public Invoker() {
        stringToCommand.put("roll", new Roll());
        stringToCommand.put("quit", new Quit());
    }

    public void setCommand(String command) {
        this.command = stringToCommand.get(command);
    }

    public void execute(Player player) {
        try {
            command.execute(player);
        } catch (NullPointerException e) {
            throw new UI.Exception(e.toString());
        }
    }


}
