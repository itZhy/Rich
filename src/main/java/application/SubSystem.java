package application;

import assistedScene.SceneManager;
import estate.EstateManager;
import player.Callback;
import player.MovementMonitor;
import prop.PropManager;
import ui.UIObserver;

public class SubSystem {
    private final MovementMonitor movementMonitor;
    private final PropManager propManager;
    private final EstateManager estateManager;
    private final SceneManager sceneManager;

    public SubSystem(UIObserver ui) {
        movementMonitor = new MovementMonitor(ui);
        propManager = new PropManager(ui);
        estateManager = new EstateManager(ui);
        sceneManager = new SceneManager(propManager, estateManager);
    }

    public PropManager getPropManager() {
        return propManager;
    }

    public EstateManager getEstateManager() {
        return estateManager;
    }

    public Callback getObservers() {
        Callback callback = new Callback();
        callback.attachForwardingObserver(propManager);
        callback.attachForwardingObserver(movementMonitor);
        callback.attachForwardedObserver(movementMonitor);
        callback.attachForwardedObserver(estateManager);
        callback.attachForwardedObserver(sceneManager);
        return callback;
    }
}