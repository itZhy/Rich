package estate;

import org.junit.Before;
import org.junit.Test;
import player.Callback;
import player.Player;
import player.Role;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VillaTest {
    private static final Money COST = new Money(200.);
    private Villa villa;
    private Role role;

    @Before
    public void setUp() {
        Player owner = new Player(Role.SunHsiaoMei, new Callback());
        role = owner.role();
        villa = new Villa(role, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_villa_to_skyscraper() {
        //when
        Building updatedBuilding = villa.update(role);
        //then
        Building villa = new Skyscraper(role, COST);
        assertThat(updatedBuilding, is(villa));
    }

    @Test
    public void it_should_earn_more_money_when_other_others_passed() {
        //given
        Money oldToll = villa.toll();
        //when
        Building skyscraper = villa.update(role);
        Money newToll = skyscraper.toll();
        //then
        assertThat(newToll, is(oldToll.multiply(2.)));
    }
}

