package Command;

import Player.Position;
import Player.Player;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_on_player () {
        //given
        Player player = new Player(new Position(0));
        Command rollCommand = new Roll();
        //when
        rollCommand.execute(player);
        //then
        assertThat(player, is(new Player(new Position(5))));
    }
}
