package Estate;

import Player.Callback;
import Player.SunHsiaoMei;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HovelTest {
    private UIObserver ui = new Map();
    private Hovel hovel;
    private String role;
    private final Integer COST = 200;

    @Before
    public void setUp() {
        SunHsiaoMei owner = new SunHsiaoMei(new Callback());
        role = owner.getClass().toString();
        hovel = new Hovel(role, ui, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_hovel_to_villa() {
        //when
        Building updatedBuilding = hovel.update(role);
        //then
        Building villa= new Villa(role, ui, COST);
        assertThat(updatedBuilding, is(villa));
    }

    @Test
    public void it_should_earn_more_money_when_other_others_passed() {
        //given
        Integer oldToll = hovel.toll();
        //when
        Building villa = hovel.update(role);
        Integer newToll = villa.toll();
        //then
        assertThat(newToll, is(oldToll * 2));
    }
}
