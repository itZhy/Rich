package Estate;

import Player.Rounder;
import UI.UIException;

public class Insolvency extends RuntimeException {
    private final String roleName;

    public Insolvency(String roleName) {
        this.roleName = roleName;
    }

    public boolean handle(EstateManager estateManager, Rounder rounder) {
        estateManager.goBankrupt(roleName);
        throw new UIException(roleName + "破产了，已经退出游戏。", !rounder.isOnlyOneRoleAfterEliminate(roleName));
    }
}
