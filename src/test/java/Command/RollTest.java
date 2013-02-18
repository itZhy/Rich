package Command;

import Player.Callback;
import Player.Feature;
import Player.Role;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_and_let_player_forward_1_steps() {
        //given
        Role role = new Role(Feature.MADAME_CHYAN, new Callback());
        Command rollCommand = new Roll();
        //when
        rollCommand.execute(role, 0);
        //then
        Role exceptedRole = new Role(Feature.MADAME_CHYAN, new Callback());
        exceptedRole.forward(1);
        assertThat(role, is(exceptedRole));
    }
}
