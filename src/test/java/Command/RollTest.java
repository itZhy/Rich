package Command;

import Player.MadameChyan;
import Player.Player;
import Player.Position;
import UI.Map;
import UI.Observer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_and_let_player_forward_1_steps() {
        //given
        Observer ui = new Map();
        Player player = new MadameChyan(new Position(0), ui);
        Command rollCommand = new Roll();
        //when
        rollCommand.execute(player);
        //then
        Player exceptedPlayer = new MadameChyan(new Position(1), ui);
        assertThat(player, is(exceptedPlayer));
    }
}
