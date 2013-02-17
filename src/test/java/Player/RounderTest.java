package Player;

import Estate.Estate;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RounderTest {
    private UIObserver ui;
    private Rounder rounder;
    private Observer building;

    @Before
    public void setUp() {
        ui = new Map();
        building = new Estate(ui);
        rounder = new Rounder();
        PlayerParser parser = new PlayerParser(ui, building);
        String players = "4213";
        for (int index = 0; index != players.length(); ++index) {
            Role role = parser.get(players.charAt(index));
            rounder.add(role);
        }
    }

    @Test
    public void it_should_get_first_player() {
        //when
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new BabyKin(new Position(0), ui, building);
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_get_third_player_when_run_next_twice() {
        //when
        rounder.next();
        rounder.next();
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new MadameChyan(new Position(0), ui, building);
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_get_first_player_when_run_next_four_times() {
        //when
        rounder.next();
        rounder.next();
        rounder.next();
        rounder.next();
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new BabyKin(new Position(0), ui, building);
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_get_second_player_when_the_first_player_is_stayed() {
        //when
        rounder.current().stay(1);
        rounder.next();
        rounder.next();
        rounder.next();
        rounder.next();
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new UncleTuu(new Position(0), ui, building);
        assertThat(currentRole, is(exceptedRole));
    }
}
