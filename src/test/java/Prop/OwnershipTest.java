package Prop;

import Player.Feature;
import org.junit.Test;

public class OwnershipTest {
    @Test
    public void uncle_tuu_should_has_barricade() {
        //given
        Ownership ownership = new Ownership();
        String owner = Feature.UNCLE_TUU;
        //when
        ownership.add(owner, 50);
        ownership.buy(owner, new Barricade(owner));
        ownership.consume(owner, new Barricade(owner));
    }
}
