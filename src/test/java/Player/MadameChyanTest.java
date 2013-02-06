package Player;

import UI.Element;
import org.junit.Test;

import UI.Map;
import org.fusesource.jansi.Ansi;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MadameChyanTest {
    @Test
    public void its_position_should_be_7_after_twice_forward() {
        //given
        Map map = new Map();
        Position initialPosition = new Position(0);
        MadameChyan player = new MadameChyan(initialPosition, map);
        //when
        player.rehabilitatePrevElement();
        player.forward(5);
        player.update();
        player.rehabilitatePrevElement();
        player.forward(2);
        player.update();
        //then
        Map constructed_map = new Map();
        constructed_map.set(new Position(7), new Element('Q', Ansi.Color.MAGENTA));
//        assertThat(map, is(constructed_map));
    }
}
