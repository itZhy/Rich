package Props;

import Estate.Estate;
import Player.MadameChyan;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BombTest {
    @Test
    public void the_role_should_be_moved_to_hospital() {
        //given
        UIObserver ui = new Map();
        String owner = UncleTuu.class.toString();
        Prop bomb = new Bomb(owner);
        //when
        Role role = new MadameChyan(new Position(0), ui, new Estate(ui));
        bomb.handle(new Position(0), role);
        //then
        Role expectedRole = new MadameChyan(new Position(0), ui, new Estate(ui));
        expectedRole.moveToHospital();
        assertThat(role, is(expectedRole));
    }
}
