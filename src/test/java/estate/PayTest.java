package estate;

import player.Role;
import player.Position;
import ui.Map;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PayTest {
    private EstateMap estateMap;
    private Bank bank;

    @Before
    public void setUp() {
        estateMap = new EstateMap(new Map());
        bank = new Bank();
    }

    @Test
    public void it_should_pay_rent_for_owner() {
        //given
        Deal pay = new Pay(estateMap, bank);
        //when
        estateMap.update(new Position(4), Role.SunHsiaoMei);
        pay.handle(new Position(4), Role.uncleTuu);
        //then
        assertThat(bank.query(Role.uncleTuu), is("\n资金： 9900元\n"));
    }

    @Test
    public void it_should_not_pay_rent_after_set_vip() {
        //given
        Deal pay = new Pay(estateMap, bank);
        bank.setMascot(Role.uncleTuu);
        //when
        estateMap.update(new Position(4), Role.SunHsiaoMei);
        pay.handle(new Position(4), Role.uncleTuu);
        //then
        assertThat(bank.query(Role.uncleTuu), is("\n资金： 10000元\n"));
    }
}
