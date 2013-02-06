package Player;

public class Player {
    public Position currentPosition;

    public Player(Position initialPosition) {
        currentPosition = initialPosition;
    }

    public void forward(int step) {
        updateUI(currentPosition, currentPosition.move(step));
        currentPosition = currentPosition.move(step);
    }

    public boolean equals(Object object) {
        return Player.class == object.getClass()&&
                currentPosition.equals(((Player) object).currentPosition);
    }

    protected void updateUI(Position source, Position destination) {};
}
