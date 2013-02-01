package Player;

public class Position {
    private final int MAX_INDEX = 69;
    private int index;

    public Position(int index) {
        this.index = index;
    }

    public void change(int step) {
        index += step;
        index %= MAX_INDEX + 1;
    }

    public boolean equals(Object position) {
        return position.getClass() == Position.class &&
                ((Position) position).index == index;
    }

    public int hashCode() {
        return index;
    }
}
