package Estate;

import Application.GameException;
import Player.Feature;
import org.junit.Test;

public class SkyscraperTest {

    @Test(expected = GameException.class)
    public void it_should_forbid_operate_player_to_update() {
        //given
        String owner = Feature.SUN_HSIAO_MEI;
        Skyscraper skyscraper = new Skyscraper(owner, 200);
        //when
        skyscraper.update(owner);
    }
}
