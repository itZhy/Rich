package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SoldVacancyTest {
    private static final int COST = 200;
    private UIObserver ui = new Map();
    private SoldVacancy soldVacancy;
    private String role;

    @Before
    public void setUp() {
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        role = owner.name();
        soldVacancy = new SoldVacancy(role, ui, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_vacancy_to_hovel() {
        //when
        Building updatedBuilding = soldVacancy.update(role);
        //then
        Building exceptedBuilding = new Hovel(role, ui, COST);
        assertThat(updatedBuilding, is(exceptedBuilding));
    }

    @Test
    public void it_should_earn_more_money_when_other_others_passed() {
        //given
        Integer oldToll = soldVacancy.toll();
        //when
        Building updatedBuilding = soldVacancy.update(role);
        Integer newToll = updatedBuilding.toll();
        //then
        assertThat(newToll, is(oldToll * 2));
    }
}
