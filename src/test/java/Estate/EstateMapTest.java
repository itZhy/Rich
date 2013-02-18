package Estate;

import Player.Feature;
import Player.Position;
import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class EstateMapTest {
    private UIObserver ui = new Map();
    @Test
    public void it_should_clear_associated_building() {
        //given
        EstateMap map = new EstateMap(ui);
        //when
        map.buy(new Position(10), Feature.MADAME_CHYAN);
        map.clearBuilding(new Position(10));
        //then
        assertThat(map, is(new EstateMap(ui)));
    }
}
