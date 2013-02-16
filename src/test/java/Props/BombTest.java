package Props;

import Estate.Estate;
import Player.MadameChyan;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.Observer;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void the_role_should_be_moved_to_hospital() {
        //given
        Observer ui = new Map();
        Role owner = new UncleTuu(new Position(0), ui, new Estate(ui));
        Prop bomb = new Bomb(owner, ui);
        //when
        Role role = new MadameChyan(new Position(0), ui, new Estate(ui));
        bomb.handle(new Position(0), role);
        //then
        Role expectedRole = new MadameChyan(new Position(0), ui, new Estate(ui));
        expectedRole.moveToHospital();
        assertThat(role, is(expectedRole));
    }
}
