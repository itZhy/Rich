package Player;

import UI.PositionExtractor;

public class Movement {
    private Position currentPosition = new Position(0);

    public void walk() {
        currentPosition = currentPosition.move(1);
    }

    public void jumpToHospital() {
        currentPosition = new PositionExtractor().getHospital();
    }

    public Position currentPosition()   {
        return currentPosition;
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() &&
                currentPosition.equals(((Movement)object).currentPosition);
    }
}
