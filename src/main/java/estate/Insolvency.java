package estate;

import application.GameException;
import player.Role;
import player.Rounder;
import utils.Checker;

public class Insolvency extends RuntimeException {
    private final Role role;

    public Insolvency(Role role) {
        this.role = role;
    }

    public void handle(EstateManager estateManager, Rounder rounder) {
        estateManager.goBankrupt(role);
        Checker.check(!rounder.isOnlyOnePlayerAfterEliminate(role), role + "破产了，游戏结束，" +
                rounder.currentPlayer().role() + "取得了最后胜利！");
        throw new GameException(role + "破产了，游戏继续。");
    }
}
