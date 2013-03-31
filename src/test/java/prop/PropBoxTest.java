package prop;

import application.GameException;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class PropBoxTest {
    @Test(expected = GameException.class)
    public void it_should_not_contains_more_than_10_props_in_a_box() {
        //given
        PropBox box = new PropBox();
        //when
        for (int count = 0; count != 11; ++count) {
            box.add(new Barricade());
        }
    }

    @Test
    public void it_should_return_query_message() {
        //given
        PropBox box = new PropBox();
        box.add(new Barricade());
        box.add(new Robot());
        box.add(new Bomb());
        //when
        String queryMessage = box.query();
        //then
        assertThat(queryMessage, is("道具：路障 1个；炸弹 1个；机器娃娃 1个"));
    }
}
