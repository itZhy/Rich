package prop;

import application.GameException;

public class Point {
    private static final int MIN_PRICE = 30;
    private Integer point;

    public Point(int point) {
        this.point = point;
    }

    public void add(Point point) {
        this.point += point.point;
    }

    public void consume(Point point) {
        this.point -= point.point;
    }

    public String toString() {
        return point.toString();
    }

    private String currentPoint() {
        return "你当前剩余点数为" + toString();
    }

    public void checkPurchasingPower(Point price) {
        if (point < MIN_PRICE) {
            throw new GameException(currentPoint() + "不足以购买任何道具。", GameException.NEED_NOT_RETRY);
        }

        if (price.point > point) {
            throw new GameException(currentPoint() + "不足以购买此道具。", GameException.NEED_RETRY);
        }
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((Point) object).point);
    }
}
