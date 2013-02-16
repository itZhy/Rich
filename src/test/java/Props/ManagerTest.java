package Props;

import Estate.Estate;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.Observer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ManagerTest {
    @Test
    public void uncle_tuu_should_has_barricade()   {
        //given
        Manager manager = new Manager();
        Map ui = new Map();
        Estate estate = new Estate(ui);
        Role uncleTuu = new UncleTuu(new Position(0), ui, estate);
        //when
        manager.add(uncleTuu, 50);
        manager.buy(uncleTuu, new Barricade(uncleTuu, ui));
        boolean isSuccessful = manager.consume(uncleTuu, new Barricade(uncleTuu, new Map()));
        //then
        assertThat(isSuccessful, is(true));
    }
}
