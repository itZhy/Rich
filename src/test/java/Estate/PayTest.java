package Estate;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PayTest {
    private UIObserver ui = new Map();
    private EstateController controller;
    private EstateMap estateMap = new EstateMap(ui);
    private Bank bank = new Bank();

    @Test
    public void it_should_pay_rent_for_owner() {
        //given
        Deal pay = new Pay(estateMap, bank);
        //when
        estateMap.update(new Position(4), Feature.SUN_HSIAO_MEI);
        pay.set(new Position(4), Feature.UNCLE_TUU);
        pay.handle();
        //then
        assertThat(bank.inquiryAccount(Feature.UNCLE_TUU), is(9900));
    }

    @Test
    public void it_should_not_pay_rent_after_set_vip() {
        //given
        Deal pay = new Pay(estateMap, bank);
        bank.setVip(Feature.UNCLE_TUU);
        //when
        estateMap.update(new Position(4), Feature.SUN_HSIAO_MEI);
        pay.set(new Position(4), Feature.UNCLE_TUU);
        pay.handle();
        //then
        assertThat(bank.inquiryAccount(Feature.UNCLE_TUU), is(10000));
    }
}
