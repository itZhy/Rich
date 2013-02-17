package Estate;

import Player.Callback;
import Player.MadameChyan;
import Player.Role;
import org.junit.Before;
import org.junit.Test;

public class EstateTest {
    private Callback callback;

    @Before
    public void setUP() {
        callback = new Callback();
    }

    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Role role = new MadameChyan(callback, callback);
        //when
    }

}
