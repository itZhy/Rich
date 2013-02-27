package Command;

import Player.Role;

public interface Command {
    public void execute(Role role, int argument);
}
