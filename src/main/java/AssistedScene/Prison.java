package AssistedScene;

import Player.Movement;
import UI.CommandLine;

public class Prison implements Scene {
    public void handle(String roleName, Movement movement) {
        showPromptMessage();
        movement.block(2);
    }

    private void showPromptMessage() {
        new CommandLine().outputInNewline("您被抓进监狱，停留2回合。");
    }
}
