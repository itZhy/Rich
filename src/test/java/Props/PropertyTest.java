package Props;

import Estate.Estate;
import Player.Position;
import Player.Role;
import Player.UncleTuu;
import UI.Map;
import UI.Observer;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PropertyTest {
    private Property property;
    Observer ui;
    Role uncleTuu;

    @Before
    public void setUp() {
        property = new Property();
        ui = new Map();
        uncleTuu = new UncleTuu(new Position(0), ui, new Estate(ui));
    }

    @Test
    public void it_should_be_able_to_afford_barricade() {
        //given
        property.add(50);
        //when
        boolean isSuccessful = property.buy(new Barricade(uncleTuu, ui));
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_has_machine_doll() {
        //given
        property.add(30);
        property.buy(new MachineDoll(ui, new PropsMap()));
        //when
        boolean isSuccessful = property.consume(new MachineDoll(ui, new PropsMap()));
        //then
        assertThat(isSuccessful, is(true));
    }

    @Test
    public void it_should_not_has_bomb()    {
        //given
        property.add(49);
        property.buy(new Bomb(uncleTuu, ui));
        //when
        boolean isSuccessful = property.consume(new Bomb(uncleTuu, ui));
        //then
        assertThat(isSuccessful, is(false));
    }
}
