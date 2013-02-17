package Estate;

import Player.*;
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
        Role babyKin = new BabyKin(new Callback());
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
        controller.buy(new Position(3), BabyKin.class.toString());
        //then
        assertThat(controller.checkPurchasingPower(BabyKin.class.toString(), vacancy), is(true));
    }

    @Test
    public void it_should_cost_200_to_buy_vacancy() {
        //when
        controller.buy(new Position(3), BabyKin.class.toString());
        //then
        Integer exceptedMoney = 10000 - 200;
        Building vacancy = new Vacancy(null, ui);
        vacancy.markPrice(exceptedMoney);
        assertThat(controller.checkPurchasingPower(BabyKin.class.toString(), vacancy), is(true));
        vacancy.markPrice(exceptedMoney + 1);
        assertThat(controller.checkPurchasingPower(BabyKin.class.toString(), vacancy), is(false));
    }

    @Test
    public void it_should_check_building_is_owned_to_player_or_not() {
        //given
        Building soldVacancy = new SoldVacancy(BabyKin.class.toString(), ui, 300);
        //then
        assertThat(controller.checkOwner(BabyKin.class.toString(), soldVacancy), is(true));
        assertThat(controller.checkOwner(SunHsiaoMei.class.toString(), soldVacancy), is(false));
    }
}
