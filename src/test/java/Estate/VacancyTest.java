package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacancyTest {
    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Map ui = new Map();
        Vacancy vacancy = new Vacancy(null, ui, 200);
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        //when
        Building soldBuilding = vacancy.update(owner.getClass().toString());
        //then
        Building exceptedBuilding = new SoldVacancy(owner.getClass().toString(), ui, 0);
        assertThat(soldBuilding, is(exceptedBuilding));
    }
}
