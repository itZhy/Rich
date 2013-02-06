package Application;

import Player.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ControllerTest {

    @Test
    public void it_should_get_an_ordered_player_list() {
        //given
        Controller session = new Controller("123");
        //then
        List<Player> test_players = new ArrayList<Player>(3);
        test_players.add(session.players.get(0));
        test_players.add(session.players.get(1));
        test_players.add(session.players.get(2));
        assertThat(session.ordered_players.size(), is(test_players.size()));
        assertThat(session.ordered_players.toString(), is(test_players.toString()));
    }

    @Test
    public void it_should_get_an_empty_player_list() {
        //given
        Controller session = new Controller("");
        //then
        assertThat(session.ordered_players.size(), is(0));
    }

    @Test(expected = UI.Exception.class)
    public void it_should_get_an_empty_player_list_and_return_error_message() {
        //given
        Controller session = new Controller("abc");
        //then
        assertThat(session.ordered_players.size(), is(0));
    }


}
