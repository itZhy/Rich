package player;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerParserTest {
    @Test
    public void it_should_translate_string_to_player() {
        //given
        PlayerParser parser = new PlayerParser(new Callback());
        //when
        Player player = parser.get('1');
        //then
        Player expectedPlayer = new Player(Role.madameChyan, new Callback());
        assertThat(player, is(expectedPlayer));
    }
}
