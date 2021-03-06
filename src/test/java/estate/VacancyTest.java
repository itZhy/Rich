package estate;

import org.junit.Test;
import player.Callback;
import player.Player;
import player.Role;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VacancyTest {
    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Vacancy vacancy = new Vacancy(new Money(200.));
        Player owner = new Player(Role.SunHsiaoMei, new Callback());
        //when
        Building soldBuilding = vacancy.update(owner.role());
        //then
        Building exceptedBuilding = new SoldVacancy(owner.role(), new Money(0.));
        assertThat(soldBuilding, is(exceptedBuilding));
    }
}
