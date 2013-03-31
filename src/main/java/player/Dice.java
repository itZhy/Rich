package player;

import java.util.Random;

public class Dice {
    private final Random random = new Random(0);

    public int roll() {
        final int UPPER_BOUND = 6;
        return 1 + random.nextInt(UPPER_BOUND);
    }
}
