package Props;

import Player.*;
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
        Role role = new MadameChyan(new Callback(), new Callback());
        bomb.handle(new Position(0), role);
        //then
        Role expectedRole = new MadameChyan(new Callback(), new Callback());
        expectedRole.moveToHospital();
        assertThat(role, is(expectedRole));
    }
}
