package Estate;

import Player.Callback;
import Player.Feature;
import Player.Role;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacancyTest {
    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Vacancy vacancy = new Vacancy(200);
        Role owner = new Role(Feature.SUN_HSIAO_MEI, new Callback());
        //when
        Building soldBuilding = vacancy.update(owner.getClass().toString());
        //then
        Building exceptedBuilding = new SoldVacancy(owner.getClass().toString(), 0);
        assertThat(soldBuilding, is(exceptedBuilding));
    }
}
