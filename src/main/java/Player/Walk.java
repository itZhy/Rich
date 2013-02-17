package Player;

import UI.PositionExtractor;

public class Walk {
    private Position currentPosition;
    private boolean isBlocked = false;
    private int remainTimes = 0;

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            currentPosition = currentPosition.move(1);
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }
    }

    public void stay(int times) {
        remainTimes = times;
    }

    public boolean skip() {
        if (0 == remainTimes) {
            return false;
        }
        --remainTimes;
        return true;
    }

    public void moveToHospital() {
        currentPosition = new PositionExtractor().getHospital();
        stay(3);
    }

    public void block() {
        isBlocked = true;
    }
}
