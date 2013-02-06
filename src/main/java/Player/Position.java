package Player;

public class Position {
    private final int MAX_INDEX = 69;
    private int index;

    public Position(int index) {
        this.index = index;
    }

    public Position move(int step) {
        return new Position((index + step) % (MAX_INDEX + 1));
    }

    public boolean equals(Object position) {
        return position.getClass() == Position.class &&
                ((Position) position).index == index;
    }

    public int hashCode() {
        return index;
    }
}
