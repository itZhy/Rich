package command;

import application.GameException;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SplitterTest {
    @Test
    public void it_should_return_bomb_as_command_name_and_10_as_command_argument() {
        //given
        Splitter splitter = new Splitter("bomb 10");
        //when
        String name = splitter.name();
        int argument = splitter.argument();
        //then
        assertThat(name, is("bomb"));
        assertThat(argument, is(10));
    }

    @Test(expected = GameException.class)
    public void it_should_throw_exception_when_the_argument_is_not_correct() {
        //given
        Splitter splitter = new Splitter("Bomb xx");
        //when
        String name = splitter.name();
        //then
        assertThat(name, is("bomb"));
        splitter.argument();
    }
}
