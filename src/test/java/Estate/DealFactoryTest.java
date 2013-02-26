package Estate;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DealFactoryTest {
    private UIObserver ui = new Map();
    private EstateMap estateMap = new EstateMap(ui);
    private Bank bank = new Bank();
    private DealFactory factory = new DealFactory(estateMap, bank);

    @Test
    public void it_should_check_whether_buy_it_or_not_when_building_is_vacancy() {
        //when
        Deal buy = factory.get(new Position(5), Feature.SUN_HSIAO_MEI);
        //then
        assertThat(buy.getClass().toString(), is(Buy.class.toString()));
    }

    @Test
    public void it_should_check_whether_update_it_or_not_when_building_is_owned() {
        //when
        estateMap.update(new Position(5), Feature.SUN_HSIAO_MEI);
        Deal update = factory.get(new Position(5), Feature.SUN_HSIAO_MEI);
        //then
        assertThat(update.getClass().toString(), is(Update.class.toString()));
    }

    @Test
    public void it_should_pay_rent_after_go_into_building_of_others() {
        //when
        estateMap.update(new Position(5), Feature.MADAME_CHYAN);
        Deal pay = factory.get(new Position(5), Feature.SUN_HSIAO_MEI);
        pay.handle();
        //then
        assertThat(pay.getClass().toString(), is(Pay.class.toString()));
        assertThat(bank.inquiryAccount(Feature.MADAME_CHYAN), is(10100));
        assertThat(bank.inquiryAccount(Feature.SUN_HSIAO_MEI), is(9900));
    }

    @Test
    public void it_should_do_nothing_when_player_not_have_enough_money() {
        //when
        bank.withdraw(Feature.SUN_HSIAO_MEI, 9900);
        Deal nullDeal = factory.get(new Position(5), Feature.SUN_HSIAO_MEI);
        //then
        assertThat(nullDeal.getClass().toString(), is(NullDeal.class.toString()));
    }
}
