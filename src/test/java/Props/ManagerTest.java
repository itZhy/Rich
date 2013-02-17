package Props;

import Player.UncleTuu;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ManagerTest {
    @Test
    public void uncle_tuu_should_has_barricade() {
        //given
        Manager manager = new Manager();
        Map ui = new Map();
        String owner = UncleTuu.class.toString();
        //when
        manager.add(owner, 50);
        manager.buy(owner, new Barricade(owner, ui));
        boolean isSuccessful = manager.consume(owner, new Barricade(owner, new Map()));
        //then
        assertThat(isSuccessful, is(true));
    }
}
