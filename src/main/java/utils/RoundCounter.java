package utils;

public class RoundCounter {
    private int maxCount = 0;

    public void pass() {
        maxCount = maxCount - 1 > 0 ? maxCount - 1 : 0;
    }

    public Boolean isExceed() {
        return maxCount <= 0;
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount + 1;
    }
}
