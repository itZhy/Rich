package assistedScene;

import player.Movement;
import ui.CommandLine;

public class Prison implements Scene {
    public void handle(String roleName, Movement movement) {
        movement.stop(2);
        showPromptMessage();
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您被抓进监狱，停留2回合。");
    }
}
