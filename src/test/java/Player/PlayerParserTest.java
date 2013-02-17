package Player;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerParserTest {
    @Test
    public void it_should_translate_string_to_player() {
        //given
        PlayerParser parser = new PlayerParser(new Callback());
        //when
        Role role = parser.get('1');
        //then
        Role expectedRole = new MadameChyan(new Callback());
        assertThat(role, is(expectedRole));
    }
}
