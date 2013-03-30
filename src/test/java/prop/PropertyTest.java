package prop;

import application.GameException;
import player.Role;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PropertyTest {
    private Property property;
    private Role owner;

    @Before
    public void setUp() {
        property = new Property();
        owner = Role.uncleTuu;
    }

    @Test
    public void it_should_be_able_to_afford_barricade() {
        //given
        property.add(new Point(50));
        //when
        property.buy(new Barricade(owner));
    }

    @Test
    public void it_should_has_machine_doll() {
        //given
        property.add(new Point(30));
        property.buy(new Robot());
        //when
        property.consume(new Robot());
    }

    @Test(expected = GameException.class)
    public void it_should_not_has_bomb() {
        //given
        property.add(new Point(49));
        property.buy(new Bomb(owner));
        //when
        property.consume(new Bomb(owner));
    }

    @Test
    public void it_should_return_query_message() {
        //given
        property.add(new Point(100));
        property.buy(new Robot());
        //when
        String queryMessage = property.query();
        //then
        assertThat(queryMessage, is("点数： 70点\n道具：路障 0个；炸弹 0个；机器娃娃 1个"));
    }
}