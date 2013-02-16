package Player;

import UI.Map;
import UI.Observer;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerParserTest {
    @Test
    public void it_should_translate_string_to_player() {
        //given
        Observer ui = new Map();
        PlayerParser parser = new PlayerParser(new Map());
        //when
        Role role = parser.get('1');
        //then
        Role expectedRole = new MadameChyan(new Position(0), ui);
        assertThat(role, is(expectedRole));
    }
}
