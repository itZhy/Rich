package Player;

import UI.PositionExtractor;

public class Movement {
    private Position currentPosition = new Position(0);
    private Position previousPosition = new Position(0);
    private int stayTimes = 0;

    public void walk() {
        previousPosition = currentPosition;
        currentPosition = currentPosition.offset(1);
    }

    public boolean skip() {
        if (stayTimes > 0) {
            --stayTimes;
            return true;
        }
        return false;
    }

    public void stop(int times) {
        stayTimes = times;
    }

    public void jumpToHospital() {
        previousPosition = currentPosition;
        currentPosition = new PositionExtractor().getHospital();
        stop(3);
    }

    public Position currentPosition() {
        return currentPosition;
    }

    public Position previousPosition() {
        return previousPosition;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                previousPosition.equals(((Movement) object).previousPosition) &&
                currentPosition.equals(((Movement) object).currentPosition);
    }
}