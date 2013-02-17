package Props;

import Player.BabyKin;
import Player.Callback;
import Player.MadameChyan;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BarricadeTest {
    @Test
    public void the_role_should_be_blocked_when_forwarding() {
        //given
        UIObserver ui = new Map();
        String owner = MadameChyan.class.toString();
        Prop barricade = new Barricade(owner);
        //when
        BabyKin babyKin = new BabyKin(new Position(0), ui, new Callback());
        barricade.handle(new Position(1), babyKin);
        babyKin.forward(10);
        //then
        assertThat(babyKin, is(new BabyKin(new Position(1), ui, new Callback())));
    }
}
