package assistedScene;

import player.Movement;
import player.Role;
import ui.CommandLine;

public class Prison implements Scene {
    public void handle(Role role, Movement movement) {
        movement.block(2);
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您被抓进监狱，停留2回合。");
    }
}
