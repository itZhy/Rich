package Player;

import UI.Map;
import UI.UIObserver;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerParserTest {
    @Test
    public void it_should_translate_string_to_player() {
        //given
        UIObserver ui = new Map();
        Callback callback = new Callback();
        PlayerParser parser = new PlayerParser(ui, callback);
        //when
        Role role = parser.get('1');
        //then
        Role expectedRole = new MadameChyan(ui, callback);
        assertThat(role, is(expectedRole));
    }
}
