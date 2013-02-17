package Player;

import UI.PositionExtractor;

public class Movement {
    private Position currentPosition = new Position(0);
    private Position previousPosition = new Position(0);

    public void walk() {
        recordPreviousPosition();
        currentPosition = currentPosition.move(1);
    }

    public void jumpToHospital() {
        recordPreviousPosition();
        currentPosition = new PositionExtractor().getHospital();
    }

    public Position currentPosition()   {
        return currentPosition;
    }

    public Position previousPosition()  {
        return previousPosition;
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Movement)object).currentPosition);
    }

    private void recordPreviousPosition()   {
        previousPosition = currentPosition;
    }
}
