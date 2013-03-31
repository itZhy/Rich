package player;

public class Position {
    private final int index;

    public Position(int index) {
        this.index = index;
    }

    public Position offset(int step) {
        final int MAX_INDEX = 69;
        return new Position((MAX_INDEX + 1 + index + step) % (MAX_INDEX + 1));
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                index == ((Position) object).index;
    }

    public int hashCode() {
        return index;
    }
}