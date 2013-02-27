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
        boolean result = controller.checkSoldStatus(new Position(3));
        //then
        assertThat(result, is(false));
    }

    @Test
    public void it_should_enable_to_buy_vacancy() {
        //given
        Building vacancy = new Vacancy(null, ui, 200);
        //when
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //then
        assertThat(controller.checkPurchasingPower(Feature.BABY_KIN, vacancy), is(true));
    }

    @Test
    public void it_should_cost_200_to_buy_vacancy() {
        //when
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //then
        Integer exceptedMoney = 10000 - 200;
        Building vacancy = new Vacancy(null, ui, exceptedMoney);
        assertThat(controller.checkPurchasingPower(Feature.BABY_KIN, vacancy), is(true));
        vacancy.markPrice(exceptedMoney + 1);
        assertThat(controller.checkPurchasingPower(Feature.BABY_KIN, vacancy), is(false));
    }

    @Test
    public void it_should_check_building_is_owned_to_player_or_not() {
        //given
        Building soldVacancy = new SoldVacancy(Feature.BABY_KIN, ui, 300);
        //then
        assertThat(controller.checkOwner(Feature.BABY_KIN, soldVacancy), is(true));
        assertThat(controller.checkOwner(Feature.SUN_HSIAO_MEI, soldVacancy), is(false));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        estateMap.update(new Position(3), Feature.BABY_KIN);
        bank.withdraw(Feature.BABY_KIN, estateMap.get(new Position(3)).price);
        //when
        boolean result = controller.checkSoldStatus(new Position(3));
        //then
        assertThat(result, is(true));
    }
}
