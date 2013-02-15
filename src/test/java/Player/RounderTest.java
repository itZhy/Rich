package Player;

import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RounderTest {
    private Observer ui;
    private Rounder rounder;

    @Before
    public void setUp() {
        ui = new Map();
        rounder = new Rounder();
        PlayerParser parser = new PlayerParser(ui);
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
        Role exceptedRole = new BabyKin(new Position(0), ui);
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_get_third_player_when_run_next_twice() {
        //when
        rounder.next();
        rounder.next();
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new MadameChyan(new Position(0), ui);
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
        Role exceptedRole = new BabyKin(new Position(0), ui);
        assertThat(currentRole, is(exceptedRole));
    }
}
