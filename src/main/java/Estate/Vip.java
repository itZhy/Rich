package Estate;

public class Vip {
    private static final Integer LIMITATION = 5;
    private Integer deadline = 0;

    public void set() {
        deadline = LIMITATION;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                deadline.equals(((Vip) object).deadline);
    }

    public void pass() {
        if (deadline > 0) {
            deadline--;
        }
    }

    public boolean vipStatus() {
        return deadline > 0;
    }
}
