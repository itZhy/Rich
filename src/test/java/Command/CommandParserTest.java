package Command;

import Prop.PropManager;
import UI.Map;
import UI.UIObserver;
import Estate.Estate;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandParserTest {
    @Test
    public void it_should_translate_string_to_command() {
        //given
        UIObserver ui = new Map();
        CommandParser parser = new CommandParser(new PropManager(ui), new Estate(ui));
        //when
        Command command = parser.get("roll");
        //then
        Command expectedCommand = new Roll();
        assertThat(command, is(expectedCommand));
    }
}