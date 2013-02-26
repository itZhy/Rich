package Estate;

import Player.Callback;
import Player.Feature;
import Player.Position;
import Player.Role;
import UI.Map;
import UI.UIObserver;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EstateManagerTest {
    private UIObserver ui = new Map();
    private EstateManager manager;

    @Before
    public void setUp() {
        manager = new EstateManager(ui);
    }

}
