package Player;

public abstract class Role {
    private final Callback forwarded;
    private final Callback forwarding;
    private Movement movement = new Movement();
    private int remainTimes = 0;
    private boolean isBlocked = false;

    Role(Callback forwarding, Callback forwarded) {
        this.forwarding = forwarding;
        this.forwarded = forwarded;
    }

    public String name() {
        return getClass().toString();
    }

    public void forward(int step) {
        for (int count = 1; count <= step; ++count) {
            movement.walk();
            forwarding.notify(name(), movement);
            if (isBlocked) {
                isBlocked = false;
                break;
            }
        }

        forwarded.notify(name(), movement);
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
        movement.jumpToHospital();
        stay(3);
        forwarding.notify(name(), movement);
    }

    public void block() {
        isBlocked = true;
    }

    public Position currentPosition() {
        return movement.currentPosition();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() && movement.equals(((Role) object).movement) &&
                remainTimes == ((Role) object).remainTimes && isBlocked == ((Role) object).isBlocked;
    }

    public abstract String getPromptMessage();
}
