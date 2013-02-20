package Command;

import Application.SubSystem;
import UI.Map;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommandParserTest {
    @Test
    public void it_should_translate_string_to_command() {
        //given
        CommandParser parser = new CommandParser(new SubSystem(new Map()));
        //when
        Command command = parser.get("roll");
        //then
        Command expectedCommand = new Roll();
        assertThat(command, is(expectedCommand));
    }
}