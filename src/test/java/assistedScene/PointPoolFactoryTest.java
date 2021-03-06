package assistedScene;

import org.junit.Test;
import player.Position;
import prop.Point;
import prop.PropManager;

import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PointPoolFactoryTest {
    @Test
    public void it_should_return_a_map_contains_position_66_with_100_points() {
        //given
        PropManager propManager = new PropManager(new ui.Map());
        PointPoolFactory pointPoolFactory = new PointPoolFactory(propManager);
        //when
        Map<Position, Scene> results = pointPoolFactory.get();
        //then
        Scene expectedScene = new PointPool(new Point(100), propManager);
        assertThat(results.get(new Position(66)), is(expectedScene));
    }
}
