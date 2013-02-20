package AssistedScene;

import UI.UIException;

public class Quit implements Selector {
    public void select(String roleName) {
        throw new UIException("欢迎下次光临。", UIException.NEED_NOT_RETRY);
    }
}