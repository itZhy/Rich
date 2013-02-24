package Prop;

import Player.Feature;
import UI.UIException;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class OwnershipTest {
    private Ownership ownership;
    private String owner;

    @Before
    public void setUp() {
        ownership = new Ownership();
        owner = Feature.UNCLE_TUU;
    }

    @Test
    public void it_should_succeed_in_consuming_a_barricade() {
        //when
        ownership.add(owner, 50);
        ownership.buy(owner, new Barricade(owner));
        ownership.consume(owner, new Barricade(owner));
    }

    @Test(expected = UIException.class)
    public void it_should_throw_an_exception_when_sell_a_tool_which_is_not_exist() {
        //when
        ownership.sell(owner, new Barricade(owner));
    }

    @Test
    public void it_should_succeed_in_selling_a_bomb() {
        //given
        ownership.add(owner, 50);
        ownership.buy(owner, new Bomb(owner));
        //when
        ownership.sell(owner, new Bomb(owner));
        //then
        Ownership expectedOwnership = new Ownership();
        expectedOwnership.add(owner, 50);
        assertThat(ownership, is(expectedOwnership));
    }
}
