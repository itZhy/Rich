package command;

import player.Role;

public interface Command {
    public void execute(Role role, int argument);
}
