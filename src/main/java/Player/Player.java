package Player;

public class Player {
    private final Position currentPosition;

    public Player(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public void forward(int step) {
        currentPosition.change(step);
    }

    public boolean equals(Object player) {
        return player.getClass() == Player.class &&
                currentPosition.equals(((Player) player).currentPosition);
    }
}
