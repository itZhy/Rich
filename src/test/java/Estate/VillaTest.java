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

public class VillaTest {
    private static final int COST = 200;
    private UIObserver ui = new Map();
    private Villa villa;
    private String role;

    @Before
    public void setUp() {
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        role = owner.name();
        villa = new Villa(role, ui, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_villa_to_skyscraper() {
        //when
        Building updatedBuilding = villa.update(role);
        //then
        Building villa = new Skyscraper(role, ui, COST);
        assertThat(updatedBuilding, is(villa));
    }

    @Test
    public void it_should_earn_more_money_when_other_others_passed() {
        //given
        Integer oldToll = villa.toll();
        //when
        Building skyscraper = villa.update(role);
        Integer newToll = skyscraper.toll();
        //then
        assertThat(newToll, is(oldToll * 2));
    }
}

