package AssistedScene;

import Application.GameException;

public class Quit implements Selector {
    public void select(String roleName) {
        throw new GameException("欢迎下次光临。", GameException.NEED_NOT_RETRY);
    }
}