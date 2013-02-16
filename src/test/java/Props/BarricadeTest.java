package Props;

import Player.BabyKin;
import Player.MadameChyan;
import Player.Position;
import Player.Role;
import UI.Map;
import UI.Observer;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class BarricadeTest {
    @Test
    public void the_role_should_be_blocked_when_forwarding()    {
        //given
        Observer ui = new Map();
        Role owner = new MadameChyan(new Position(0), ui);
        Prop barricade = new Barricade(owner, ui);
        //when
        BabyKin babyKin = new BabyKin(new Position(0), ui);
        barricade.handle(babyKin);
        babyKin.forward(10);
        //then
        assertThat(babyKin, is(new BabyKin(new Position(1), ui)));
    }
}
