package estate;

import application.GameException;
import player.Role;
import player.Rounder;

public class Insolvency extends RuntimeException {
    private final Role role;

    public Insolvency(Role role) {
        this.role= role;
    }

    public void handle(EstateManager estateManager, Rounder rounder) {
        estateManager.goBankrupt(role);
        if (rounder.isOnlyOnePlayerAfterEliminate(role)) {
            throw new GameException(role.toString() + "破产了，游戏结束，" +
                    rounder.currentPlayer().role().toString() + "取得了最后胜利！", GameException.NEED_NOT_RETRY);
        }
        throw new GameException(role.toString() + "破产了，游戏继续。", GameException.NEED_RETRY);
    }
}
