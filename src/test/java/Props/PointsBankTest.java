package Props;

import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointsBankTest {
    @Test
    public void uncle_tuu_should_has_15_points_after_added() {
        //given
        PointsBank pointsBank = new PointsBank();
        Role uncleTuu = new UncleTuu(new Position(0), new Map());
        //when
        pointsBank.add(uncleTuu, 5);
        pointsBank.add(uncleTuu, 10);
        //then
        PointsBank expectedPointsBank = new PointsBank();
        expectedPointsBank.add(uncleTuu, 15);
        assertThat(pointsBank, is(expectedPointsBank));
    }
}
