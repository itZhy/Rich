package Prop;

import Player.UncleTuu;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OwnershipTest {
    @Test
    public void uncle_tuu_should_has_barricade() {
        //given
        Ownership ownership = new Ownership();
        String owner = UncleTuu.class.toString();
        //when
        ownership.add(owner, 50);
        ownership.buy(owner, new Barricade(owner));
        boolean isSuccessful = ownership.consume(owner, new Barricade(owner));
        //then
        assertThat(isSuccessful, is(true));
    }
}
