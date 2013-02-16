package Props;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyTest {
    private Property property;

    @Before
    public void setUp() {
        property = new Property();
    }

    @Test
    public void it_should_be_able_to_afford_barricade() {
        //given
        property.add(50);
        //when
        boolean isSuccessful = property.buy(new Barricade());
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_has_machine_doll() {
        //given
        property.add(30);
        property.buy(new MachineDoll());
        //when
        boolean isSuccessful = property.consume(new MachineDoll());
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_not_has_bomb()    {
        //given
        property.add(49);
        property.buy(new Bomb());
        //when
        boolean isSuccessful = property.consume(new Bomb());
        //then
        assertThat(isSuccessful, is(false));
    }
}
