package Estate;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BankTest {
    private UIObserver ui = new Map();
    private EstateMap estateMap = new EstateMap(ui);
    private Bank bank = new Bank();

    @Test
    public void it_should_add_account_money_earn_money() {
        //given
        String role = Feature.MADAME_CHYAN;
        //when
        bank.earnMoney(role, 200);
        //then
        bank.withdraw(role, 200);
        Bank exceptedBank = new Bank();
        exceptedBank.checkPurchasingPower(role, 200);
        assertThat(bank, is(exceptedBank));
    }

    @Test
    public void it_should_get_account_information() {
        //given
        String role = Feature.MADAME_CHYAN;
        //when
        bank.earnMoney(role, 200);
        //then
        assertThat(bank.query(role), is("\n资金： 10200元\n"));
        assertThat(bank.query(Feature.UNCLE_TUU), is("\n资金： 10000元\n"));
    }

    @Test
    public void it_should_get_twice_money_after_sell_building() {
        //when
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).basePrice);
        bank.earnMoney(Feature.BABY_KIN, estateMap.get(new Position(3)).sellingPrice());
        estateMap.clearBuilding(new Position(3));
        //then
        Assert.assertThat(bank.query(Feature.BABY_KIN), is("\n资金： 10200元\n"));
    }
}
