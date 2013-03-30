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
            Player player = parser.get(players.charAt(index));
            rounder.add(player);
        }
    }

    @Test
    public void it_should_get_first_player() {
        //when
        Player currentPlayer = rounder.currentPlayer();
        //then
        Player exceptedPlayer = new Player(Role.babyKin, new Callback());
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_third_player_when_run_next_twice() {
        //when
        rounder.nextPlayer();
        rounder.nextPlayer();
        Player currentPlayer = rounder.currentPlayer();
        //then
        Player exceptedPlayer = new Player(Role.madameChyan, new Callback());
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_get_first_player_when_run_next_four_times() {
        //when
        rounder.nextPlayer();
        rounder.nextPlayer();
        rounder.nextPlayer();
        rounder.nextPlayer();
        Player currentPlayer = rounder.currentPlayer();
        //then
        Player exceptedPlayer = new Player(Role.babyKin, new Callback());
        assertThat(currentPlayer, is(exceptedPlayer));
    }

    @Test
    public void it_should_delete_corresponding_player_when_player_encounter_bankrupt(){
        //when
        rounder.isOnlyOnePlayerAfterEliminate(Role.babyKin);
        //then
        Rounder exceptedRounder = new Rounder();
        PlayerParser parser = new PlayerParser(new Callback());
        String players = "213";
        for (int index = 0; index != players.length(); ++index) {
            Player player = parser.get(players.charAt(index));
            exceptedRounder.add(player);
        }
        assertThat(rounder, is(exceptedRounder));
    }
}
