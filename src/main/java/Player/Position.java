package Player;

public class Position {
    private Integer index;

    public Position(int index) {
        this.index = index;
    }

    public void change(int step) {
        index += step;
    }

    public boolean equals(Object position) {
        return position.getClass() == Position.class &&
                index.equals(((Position) position).index);
    }
}
