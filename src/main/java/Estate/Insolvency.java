package Estate;

import Application.GameException;
import Player.Rounder;

public class Insolvency extends RuntimeException {
    private final String roleName;

    public Insolvency(String roleName) {
        this.roleName = roleName;
    }

    public void handle(EstateManager estateManager, Rounder rounder) {
        estateManager.goBankrupt(roleName);
        throw new GameException(roleName + "破产了，已经退出游戏。", !rounder.isOnlyOneRoleAfterEliminate(roleName));
    }
}
