package Player;

import UI.PositionExtractor;

public class Movement {
    private Position currentPosition = new Position(0);
    private Position previousPosition = new Position(0);
    private int stayTimes = 0;

    public boolean walk() {
        if (stayTimes > 0) {
            --stayTimes;
            return false;
        }
        forwardOneStep();
        return true;
    }

    public boolean skip() {
        if (stayTimes > 0) {
            --stayTimes;
            return true;
        }
        return false;
    }

    public void block(int times) {
        stayTimes = times;
    }

    public void jumpToHospital() {
        recordPreviousPosition();
        currentPosition = new PositionExtractor().getHospital();
        block(3);
    }

    public Position currentPosition() {
        return currentPosition;
    }

    public Position previousPosition() {
        return previousPosition;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Movement) object).currentPosition);
    }

    private void forwardOneStep() {
        recordPreviousPosition();
        currentPosition = currentPosition.move(1);
    }

    private void recordPreviousPosition() {
        previousPosition = currentPosition;
    }
}
