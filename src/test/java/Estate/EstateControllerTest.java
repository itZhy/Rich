package Estate;

import Player.Callback;
import Player.Feature;
import Player.Position;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EstateControllerTest {
    private UIObserver ui = new Map();
    private EstateController controller;

    @Before
    public void setUp() {
        controller = new EstateController(ui);
    }

    @Test
    public void it_should_check_field_is_vacant() {
        //given
        Building vacancy = new Vacancy(null, ui);
        //when
        boolean result = controller.checkSoldStatus(vacancy);
        //then
        assertThat(result, is(false));
    }

    @Test
    public void it_should_check_field_is_not_vacant() {
        //given
        Role babyKin = new Role(Feature.BABY_KIN, new Callback());
        Building skyscraper = new Skyscraper(babyKin.getClass().toString(), ui, 0);
        //when
        boolean result = controller.checkSoldStatus(skyscraper);
        //then
        assertThat(result, is(true));
    }

    @Test
    public void it_should_enable_to_buy_vacancy() {
        //given
        Building vacancy = new Vacancy(null, ui);
        vacancy.markPrice(200);
        //when
        controller.buy(new Position(3), Feature.BABY_KIN);
        //then
        assertThat(controller.checkPurchasingPower(Feature.BABY_KIN, vacancy), is(true));
    }

    @Test
    public void it_should_cost_200_to_buy_vacancy() {
        //when
        controller.buy(new Position(3), Feature.BABY_KIN);
        //then
        Integer exceptedMoney = 10000 - 200;
        Building vacancy = new Vacancy(null, ui);
        vacancy.markPrice(exceptedMoney);
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
    public void it_should_get_twice_money_after_sell_building(){
        //when
        controller.buy(new Position(3), Feature.BABY_KIN);
        controller.sell(new Position(3), Feature.BABY_KIN);
        //then
        assertThat(controller.inquiry(Feature.BABY_KIN), is(10200));
    }
}
