package Estate;

class Vip {
    private int limitation = 5;

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                limitation == ((Vip) object).limitation;
    }

    public void pass() {
        if (limitation > 0) {
            limitation--;
        }
    }

    public boolean isExpired() {
        return 0 == limitation;
    }
}
