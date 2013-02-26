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
    private EstateMap map = new EstateMap(ui);

    @Test
    public void it_should_update_building_after_payed(){
        //when
        map.update(new Position(10), Feature.MADAME_CHYAN);
        map.update(new Position(10), Feature.MADAME_CHYAN);
        //then
        assertThat(map.get(new Position(10)), is((Building)new Hovel(Feature.MADAME_CHYAN, ui, 200)));
    }

    @Test
    public void it_should_clear_associated_building() {
        //when
        map.update(new Position(10), Feature.MADAME_CHYAN);
        map.clearBuilding(new Position(10));
        //then
        assertThat(map, is(new EstateMap(ui)));
    }

    @Test
    public void it_should_clear_all_buildings_of_player_after_insolvency() {
        //given
        EstateMap map = new EstateMap(ui);
        //when
        map.update(new Position(10), Feature.MADAME_CHYAN);
        map.update(new Position(24), Feature.MADAME_CHYAN);
        map.update(new Position(25), Feature.BABY_KIN);
        map.clearBuildings(Feature.MADAME_CHYAN);
        //then
        EstateMap exceptedMap = new EstateMap(ui);
        exceptedMap.update(new Position(25), Feature.BABY_KIN);
        assertThat(map, is(exceptedMap));
    }
}
