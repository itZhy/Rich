package AssistedScene;

import Player.Position;
import Prop.PropManager;
import UI.PositionExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointPoolFactory {
    private final PropManager propManager;
    private final List<Integer> pointsInEachPosition = new ArrayList<Integer>();

    public PointPoolFactory(PropManager propManager) {
        this.propManager = propManager;
        initializePointsInEachPosition();
    }

    public Map<Position, Scene> get() {
        Map<Position, Scene> pointsPools = new HashMap<Position, Scene>();
        List<Position> positions = new PositionExtractor().getPointsPools();
        for (int index = 0; index != positions.size(); ++index) {
            pointsPools.put(positions.get(index), new PointPool(pointsInEachPosition.get(index), propManager));
        }
        return pointsPools;
    }

    private void initializePointsInEachPosition() {
        pointsInEachPosition.add(20);
        pointsInEachPosition.add(80);
        pointsInEachPosition.add(100);
        pointsInEachPosition.add(40);
        pointsInEachPosition.add(80);
        pointsInEachPosition.add(60);
    }
}
