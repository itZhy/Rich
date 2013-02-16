package Props;

import Estate.Estate;
import Player.BabyKin;
import Player.MadameChyan;
import Player.Position;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BarricadeTest {
    @Test
    public void the_role_should_be_blocked_when_forwarding()    {
        //given
        UIObserver ui = new Map();
        Role owner = new MadameChyan(new Position(0), ui, new Estate(ui));
        Prop barricade = new Barricade(owner, ui);
        //when
        BabyKin babyKin = new BabyKin(new Position(0), ui, new Estate(ui));
        barricade.handle(new Position(1), babyKin);
        babyKin.forward(10);
        //then
        assertThat(babyKin, is(new BabyKin(new Position(1), ui, new Estate(ui))));
    }
}
