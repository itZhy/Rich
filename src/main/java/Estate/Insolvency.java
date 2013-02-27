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
        if (rounder.isOnlyOneRoleAfterEliminate(roleName)) {
            throw new GameException(roleName + "破产了，游戏结束，" +
                    rounder.current().name() + "取得了最后胜利！", GameException.NEED_NOT_RETRY);
        }
        throw new GameException(roleName + "破产了，游戏继续。");
    }
}
