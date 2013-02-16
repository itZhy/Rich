package Player;

import Estate.Estate;
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
        Estate estate = new Estate(ui);
        PlayerParser parser = new PlayerParser(ui, estate);
        //when
        Role role = parser.get('1');
        //then
        Role expectedRole = new MadameChyan(new Position(0), ui, estate);
        assertThat(role, is(expectedRole));
    }
}
