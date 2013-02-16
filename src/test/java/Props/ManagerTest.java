package Props;

import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ManagerTest {
    @Test
    public void uncle_tuu_should_has_barricade()   {
        //given
        Manager manager = new Manager();
        Role uncleTuu = new UncleTuu(new Position(0), new Map());
        //when
        manager.add(uncleTuu, 50);
        manager.buy(uncleTuu, new Barricade());
        boolean isSuccessful = manager.consume(uncleTuu, new Barricade());
        //then
        assertThat(isSuccessful, is(true));
    }
}
