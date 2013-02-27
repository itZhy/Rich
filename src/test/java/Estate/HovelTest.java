package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HovelTest {
    private static final int COST = 200;
    private Hovel hovel;
    private String role;

    @Before
    public void setUp() {
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        role = owner.name();
        hovel = new Hovel(role, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_hovel_to_villa() {
        //when
        Building updatedBuilding = hovel.update(role);
        //then
        Building villa = new Villa(role, COST);
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

    @Test
    public void it_should_earn_more_money_when_selling_building() {
        //given
        Integer oldPrice = hovel.sellingPrice();
        //when
        Building villa = hovel.update(role);
        Integer newPrice = villa.sellingPrice();
        //then
        assertThat(newPrice, is(oldPrice * 2));
    }
}
