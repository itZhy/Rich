package estate;

import org.junit.Before;
import org.junit.Test;
import player.Role;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HovelTest {
    private static final Money COST = new Money(200.);
    private Hovel hovel;
    private Role role;

    @Before
    public void setUp() {
        role = Role.SunHsiaoMei;
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
        Money oldToll = hovel.toll();
        //when
        Building villa = hovel.update(role);
        Money newToll = villa.toll();
        //then
        assertThat(newToll, is(oldToll.multiply(2.)));
    }

    @Test
    public void it_should_earn_more_money_when_selling_building() {
        //given
        Money oldPrice = hovel.sellingPrice();
        //when
        Building villa = hovel.update(role);
        Money newPrice = villa.sellingPrice();
        //then
        assertThat(newPrice, is(oldPrice.multiply(2.)));
    }
}
