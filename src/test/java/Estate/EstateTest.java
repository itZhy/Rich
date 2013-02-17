package Estate;

import Player.Callback;
import Player.MadameChyan;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

public class EstateTest {
    private Callback callback;
    private UIObserver ui;

    @Before
    public void setUP() {
        ui = new Map();
        Callback callback = new Callback();
    }

    @Test
    public void it_should_operate_player_to_buy_house() {
        //given
        Role role = new MadameChyan(ui, callback);
        //when
    }

}
