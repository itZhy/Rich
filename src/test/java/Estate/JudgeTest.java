package estate;

import player.Role;
import player.Position;
import ui.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JudgeTest {
    private Judge controller;
    private EstateMap estateMap;
    private Bank bank;

    @Before
    public void setUp() {
        estateMap = new EstateMap(new Map());
        bank = new Bank();
        controller = new Judge(estateMap, bank);
    }

    @Test
    public void it_should_check_field_is_vacant() {
        //when
        boolean result = controller.isMetToBuy(new Position(3), null);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void it_should_enable_to_update_vacancy() {
        //when
        estateMap.update(new Position(3), Role.babyKin);
        bank.withdraw(Role.babyKin, estateMap.get(new Position(3)).basePrice);
        //then
        assertThat(controller.isMetToUpdate(new Position(3), Role.babyKin), is(true));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        estateMap.update(new Position(3), Role.babyKin);
        bank.withdraw(Role.babyKin, estateMap.get(new Position(3)).basePrice);
        //when
        boolean result = controller.isMetToUpdate(new Position(3), Role.babyKin);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void it_should_pay_rent_for_owner_of_building() {
        //given
        estateMap.update(new Position(3), Role.babyKin);
        bank.withdraw(Role.babyKin, estateMap.get(new Position(3)).basePrice);
        //then
        assertThat(controller.isMetToPay(new Position(3), Role.madameChyan), is(true));
    }
}
