package estate;

import application.GameException;
import player.Role;
import org.junit.Test;

public class SkyscraperTest {

    @Test(expected = GameException.class)
    public void it_should_forbid_operate_player_to_update() {
        //given
        Role owner = Role.SunHsiaoMei;
        Skyscraper skyscraper = new Skyscraper(owner, 200);
        //when
        skyscraper.update(owner);
    }
}
