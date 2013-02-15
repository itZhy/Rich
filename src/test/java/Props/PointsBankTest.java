package Props;

import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PointsBankTest {
    private PointsBank pointsBank;
    private Role uncleTuu;

    @Before
    public void setUp() {
        pointsBank = new PointsBank();
        uncleTuu = new UncleTuu(new Position(0), new Map());
    }

    @Test
    public void uncle_tuu_should_has_15_points_after_added() {
        //when
        pointsBank.deposit(uncleTuu, 5);
        pointsBank.deposit(uncleTuu, 10);
        //then
        PointsBank expectedPointsBank = new PointsBank();
        expectedPointsBank.deposit(uncleTuu, 15);
        assertThat(pointsBank, is(expectedPointsBank));
    }

    @Test
    public void uncle_tuu_should_not_be_able_to_afford_a_prop_worth_30_points() {
        //when
        pointsBank.deposit(uncleTuu, 29);
        boolean isSuccessful = pointsBank.withdraw(uncleTuu, 30);
        //then
        assertThat(isSuccessful, is(false));
    }

    @Test
    public void uncle_tuu_should_be_able_to_afford_a_prop_worth_50_points() {
        //when
        pointsBank.deposit(uncleTuu, 50);
        boolean isSuccessful = pointsBank.withdraw(uncleTuu, 50);
        //then
        assertThat(isSuccessful, is(true));
    }
}
