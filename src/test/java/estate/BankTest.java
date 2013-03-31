package estate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.Position;
import player.Role;
import ui.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankTest {
    private EstateMap estateMap;
    private Bank bank;

    @Before
    public void setUp() {
        estateMap = new EstateMap(new Map());
        bank = new Bank();
    }

    @Test
    public void it_should_add_account_money_earn_money() {
        //given
        Role role = Role.madameChyan;
        //when
        bank.add(role, new Money(200.));
        //then
        bank.withdraw(role, new Money(200.));
        Bank exceptedBank = new Bank();
        exceptedBank.checkPurchasingPower(role, new Money(200.));
        assertThat(bank, is(exceptedBank));
    }

    @Test
    public void it_should_get_account_information() {
        //given
        Role role = Role.madameChyan;
        //when
        bank.add(role, new Money(200.));
        //then
        assertThat(bank.query(role), is("\n资金： 10200.0元\n"));
        assertThat(bank.query(Role.uncleTuu), is("\n资金： 10000.0元\n"));
    }

    @Test
    public void it_should_get_twice_money_after_sell_building() {
        //when
        estateMap.update(new Position(3), Role.babyKin);
        bank.withdraw(Role.babyKin, estateMap.get(new Position(3)).basePrice);
        bank.add(Role.babyKin, estateMap.get(new Position(3)).sellingPrice());
        estateMap.clearBuilding(new Position(3));
        //then
        Assert.assertThat(bank.query(Role.babyKin), is("\n资金： 10200.0元\n"));
    }
}
