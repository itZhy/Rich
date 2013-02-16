package Estate;
import Player.Position;
import Player.SunHsiaoMei;
import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;
import sun.print.SunMinMaxPage;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacancyTest {
    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Map ui = new Map();
        Vacancy vacancy = new Vacancy(ui);
        SunHsiaoMei owner = new SunHsiaoMei(new Position(0), ui);
        //when
        Building nextBuilding = vacancy.update(owner);
        //then
        Building exceptedBuilding = new SoldVacancy(owner, ui);
        assertThat(nextBuilding, is(exceptedBuilding));
    }
}
