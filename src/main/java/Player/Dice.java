package Player;

import java.util.Random;

public class Dice {
    private final Random random = new Random(0);
    private static final int upperBound = 6;
    private boolean enable = true;

    public int roll() {
        return 1 + random.nextInt(upperBound);
    }
}
