package Estate;
import Player.Callback;
import Player.SunHsiaoMei;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacancyTest {
    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Map ui = new Map();
        Callback callback = new Callback();
        Vacancy vacancy = new Vacancy(null, ui);
        SunHsiaoMei owner = new SunHsiaoMei(ui, callback);
        //when
        Building nextBuilding = vacancy.update(owner.getClass().toString());
        //then
        Building exceptedBuilding = new SoldVacancy(owner.getClass().toString(), ui);
        assertThat(nextBuilding, is(exceptedBuilding));
    }
}
