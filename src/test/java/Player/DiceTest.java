package Player;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DiceTest {
    @Test
    public void its_return_value_should_between_0_and_6() {
        //given
        Dice dice = new Dice();
        //when
        int value = dice.roll();
        //then
        assertThat(value, allOf(greaterThan(0), lessThanOrEqualTo(6)));
    }
}
