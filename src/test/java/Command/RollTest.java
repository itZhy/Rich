package Command;

import Player.Callback;
import Player.MadameChyan;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_and_let_player_forward_1_steps() {
        //given
        Callback callback = new Callback();
        Role role = new MadameChyan(callback, callback);
        Command rollCommand = new Roll();
        //when
        rollCommand.execute(role, 0);
        //then
        Role exceptedRole = new MadameChyan(callback, callback);
        exceptedRole.forward(1);
        assertThat(role, is(exceptedRole));
    }
}
