package Player;

public class Position {
    private Integer index;
    private final Integer maxIndex = 69;


    public Position(int index) {
        this.index = index;
    }

    public void change(int step) {
        index += step;
        index %= maxIndex + 1;
    }

    public boolean equals(Object position) {
        return position.getClass() == Position.class &&
                index.equals(((Position) position).index);
    }
}
