package player;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RounderTest {
    private Rounder rounder;

    @Before
    public void setUp() {
        rounder = new Rounder();
        PlayerParser parser = new PlayerParser(new Callback());
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
        Role exceptedRole = new Role(Feature.BABY_KIN, new Callback());
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_get_third_player_when_run_next_twice() {
        //when
        rounder.next();
        rounder.next();
        Role currentRole = rounder.current();
        //then
        Role exceptedRole = new Role(Feature.MADAME_CHYAN, new Callback());
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
        Role exceptedRole = new Role(Feature.BABY_KIN, new Callback());
        assertThat(currentRole, is(exceptedRole));
    }

    @Test
    public void it_should_delete_corresponding_player_when_player_encounter_bankrupt(){
        //when
        rounder.isOnlyOneRoleAfterEliminate(Feature.BABY_KIN);
        //then
        Rounder exceptedRounder = new Rounder();
        PlayerParser parser = new PlayerParser(new Callback());
        String players = "213";
        for (int index = 0; index != players.length(); ++index) {
            Role role = parser.get(players.charAt(index));
            exceptedRounder.add(role);
        }
        assertThat(rounder, is(exceptedRounder));
    }
}
