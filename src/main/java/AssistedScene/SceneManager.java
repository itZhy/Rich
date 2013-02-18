package AssistedScene;

import Estate.Estate;
import Player.Movement;
import Player.Observer;
import Player.Position;
import Prop.PropManager;
import UI.PositionExtractor;

import java.util.HashMap;
import java.util.Map;

public class SceneManager implements Observer {
    private Map<Position, Scene> scenes = new HashMap<Position, Scene>();

    public SceneManager(PropManager propManager, Estate estate) {
        initializeScenes(propManager, estate);
    }

    private void initializeScenes(PropManager propManager, Estate estate) {
        scenes.putAll(new PointPoolFactory(propManager).get());
        scenes.put(new PositionExtractor().getMagicHouse(), new MagicHouse());
        scenes.put(new PositionExtractor().getGiftHouse(), new GiftHouse(propManager, estate));
        scenes.put(new PositionExtractor().getPropHouse(), new PropHouse(propManager));
        scenes.put(new PositionExtractor().getPrison(), new Prison());
    }

    public void handle(String roleName, Movement movement) {
        if (scenes.containsKey(movement.currentPosition())) {
            scenes.get(movement.currentPosition()).handle(roleName, movement);
        }
    }
}