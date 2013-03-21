package command;

import player.Callback;
import player.Role;
import player.Player;
import player.Rounder;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_and_let_player_forward_1_steps() {
        //given
        Player player = new Player(Role.madameChyan, new Callback());
        Rounder rounder = new Rounder();
        rounder.add(player);
        Command rollCommand = new Roll(rounder);
        //when
        rollCommand.execute(player, 0);
        //then
        Player exceptedPlayer = new Player(Role.madameChyan, new Callback());
        exceptedPlayer.forward(1);
        assertThat(player, is(exceptedPlayer));
    }
}
