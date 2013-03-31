package estate;

import org.junit.Before;
import org.junit.Test;
import player.Callback;
import player.Player;
import player.Role;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SoldVacancyTest {
    private static final int COST = 200;
    private SoldVacancy soldVacancy;
    private Role role;

    @Before
    public void setUp() {
        Player owner = new Player(Role.SunHsiaoMei, new Callback());
        role = owner.role();
        soldVacancy = new SoldVacancy(role, COST);
    }

    @Test
    public void it_should_operate_player_to_update_house_from_vacancy_to_hovel() {
        //when
        Building updatedBuilding = soldVacancy.update(role);
        //then
        Building exceptedBuilding = new Hovel(role, COST);
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
