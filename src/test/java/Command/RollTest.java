package Command;

import Estate.Estate;
import Player.Callback;
import Player.MadameChyan;
import Player.Role;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RollTest {
    @Test
    public void it_should_execute_roll_command_and_let_player_forward_1_steps() {
        //given
        UIObserver ui = new Map();
        Callback callback = new Callback();
        Role role = new MadameChyan(new Position(0), ui, callback);
        Command rollCommand = new Roll();
        //when
        rollCommand.execute(role, 0);
        //then
        Role exceptedRole = new MadameChyan(new Position(1), ui, callback);
        assertThat(role, is(exceptedRole));
    }
}
