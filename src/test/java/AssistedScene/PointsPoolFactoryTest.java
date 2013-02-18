package AssistedScene;

import Player.Position;
import Props.PropsManager;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointsPoolFactoryTest {
    @Test
    public void it_should_return_a_map_contains_position_66_with_100_points() {
        //given
        PropsManager propsManager = new PropsManager(new UI.Map());
        PointsPoolFactory pointsPoolFactory = new PointsPoolFactory(propsManager);
        //when
        Map<Position, Scene> results = pointsPoolFactory.get();
        //then
        Scene expectedScene = new PointsPool(100, propsManager);
        assertThat(results.get(new Position(66)), is(expectedScene));
    }
}
