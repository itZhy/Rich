package prop;

import utils.Checker;

public class Point {
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
        return "你当前剩余点数为" + point;
    }

    public void checkPurchasingPower(Point price) {
        final int MIN_PRICE = 30;
        Checker.check(point >= MIN_PRICE, currentPoint() + "不足以购买任何道具。");
        Checker.check(point >= price.point, currentPoint() + "不足以购买此道具。");
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                point.equals(((Point) object).point);
    }
}
