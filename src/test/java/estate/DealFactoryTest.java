package estate;

import org.junit.Before;
import org.junit.Test;
import player.Position;
import player.Role;
import ui.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DealFactoryTest {
    private EstateMap estateMap;
    private Bank bank;
    private DealFactory factory;

    @Before
    public void setUp() {
        estateMap = new EstateMap(new Map());
        bank = new Bank();
        factory = new DealFactory(estateMap, bank);
    }

    @Test
    public void it_should_check_whether_buy_it_or_not_when_building_is_vacancy() {
        //when
        Deal buy = factory.get(new Position(5), Role.SunHsiaoMei);
        //then
        assertThat(buy.getClass().toString(), is(Buy.class.toString()));
    }

    @Test
    public void it_should_check_whether_update_it_or_not_when_building_is_owned() {
        //when
        estateMap.update(new Position(5), Role.SunHsiaoMei);
        Deal update = factory.get(new Position(5), Role.SunHsiaoMei);
        //then
        assertThat(update.getClass().toString(), is(Update.class.toString()));
    }

    @Test
    public void it_should_pay_rent_after_go_into_building_of_others() {
        //when
        estateMap.update(new Position(5), Role.madameChyan);
        Deal pay = factory.get(new Position(5), Role.SunHsiaoMei);
        pay.handle(new Position(5), Role.SunHsiaoMei);
        //then
        assertThat(pay.getClass().toString(), is(Pay.class.toString()));
        assertThat(bank.query(Role.madameChyan), is("\n资金： 10100元\n"));
        assertThat(bank.query(Role.SunHsiaoMei), is("\n资金： 9900元\n"));
    }

    @Test
    public void it_should_do_nothing_when_player_not_have_enough_money() {
        //when
        bank.withdraw(Role.SunHsiaoMei, 9900);
        Deal nullDeal = factory.get(new Position(5), Role.SunHsiaoMei);
        //then
        assertThat(nullDeal.getClass().toString(), is(Idle.class.toString()));
    }
}
