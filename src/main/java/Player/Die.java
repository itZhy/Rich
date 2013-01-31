package Player;

import java.util.Random;

public class Die {
    private final Random random = new Random(0);
    private final int upperBound = 6;

    public int roll() {
        return random.nextInt(upperBound + 1);
    }
}
