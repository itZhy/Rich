package AssistedScene;

import Player.Position;
import Props.PropsManager;
import UI.PositionExtractor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointsPoolFactory {
    private final PropsManager propsManager;
    private final List<Integer> pointsInEachPosition = new ArrayList<Integer>();

    public PointsPoolFactory(PropsManager propsManager) {
        this.propsManager = propsManager;
        initializePointsInEachPosition();
    }

    public Map<Position, Scene> get() {
        Map<Position, Scene> pointsPools = new HashMap<Position, Scene>();
        List<Position> positions = new PositionExtractor().getPointsPools();
        for (int index = 0; index != positions.size(); ++index) {
            pointsPools.put(positions.get(index), new PointsPool(pointsInEachPosition.get(index), propsManager));
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
