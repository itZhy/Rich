package Player;

public class Position {
    private static final int MAX_INDEX = 69;
    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position offset(int step) {
        return new Position((MAX_INDEX + 1 + index + step) % (MAX_INDEX + 1));
    }

    public boolean equals(Object position) {
        return getClass() == Position.class &&
                ((Position) position).index == index;
    }

    public int hashCode() {
        return index;
    }
}