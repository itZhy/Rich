package AssistedScene;

import Estate.EstateManager;
import Player.Movement;
import Player.Observer;
import Player.Position;
import Prop.PropManager;
import UI.PositionExtractor;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements Observer {
    private final Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropManager propManager, EstateManager estateManager) {
        initializeScenes(propManager, estateManager);
    }

    private void initializeScenes(PropManager propManager, EstateManager estateManager) {
        scenes.putAll(new PointPoolFactory(propManager).get());
        scenes.put(new PositionExtractor().getMagicHouse(), new MagicHouse());
        scenes.put(new PositionExtractor().getGiftHouse(), new GiftHouse(propManager, estateManager));
        scenes.put(new PositionExtractor().getPropHouse(), new PropHouse(propManager));
        scenes.put(new PositionExtractor().getPrison(), new Prison());
    }

    public void handle(String roleName, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(roleName, movement);
        }
    }
}