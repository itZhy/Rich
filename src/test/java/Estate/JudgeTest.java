package Estate;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class JudgeTest {
    private UIObserver ui = new Map();
    private Judge controller;
    private EstateMap estateMap = new EstateMap(ui);
    private Bank bank = new Bank();

    @Before
    public void setUp() {
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
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //then
        assertThat(controller.isMetToUpdate(new Position(3), Feature.BABY_KIN), is(true));
    }

    @Test
    public void it_should_cost_200_to_buy_vacancy() {
        //when
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //then
        Integer exceptedMoney = 10000 - 200;
        estateMap.get(new Position(3)).markPrice(exceptedMoney);
        assertThat(controller.isMetToUpdate(new Position(3), Feature.BABY_KIN), is(true));
        estateMap.get(new Position(3)).markPrice(exceptedMoney + 1);
        assertThat(controller.isMetToUpdate(new Position(3), Feature.BABY_KIN), is(false));
    }

    @Test
    public void it_should_check_building_is_owned_to_player_or_not() {
        //given
        estateMap.update(new Position(25), Feature.BABY_KIN);
        //then
        assertThat(controller.checkOwner(new Position(25), Feature.BABY_KIN), is(true));
        assertThat(controller.checkOwner(new Position(25), Feature.SUN_HSIAO_MEI), is(false));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //when
        boolean result = controller.isMetToUpdate(new Position(3), Feature.BABY_KIN);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void it_should_pay_rent_for_owner_of_building() {
        //given
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //then
        assertThat(controller.isMetToPay(new Position(3), Feature.MADAME_CHYAN), is(true));
    }

    @Test
    public void it_should_check_current_position_is_building_or_not() {
        assertThat(controller.hasBuilding(new Position(19)), is(true));
        assertThat(controller.hasBuilding(new Position(0)), is(false));
    }
}
