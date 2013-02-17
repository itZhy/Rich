package Estate;

import Player.*;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
        Role role = new MadameChyan(new Position(3), ui, callback);
        //when
    }

}
