package Prop;

public class Property {
    private int points = 0;
    private PropBox box = new PropBox();

    public void add(int point) {
        points += point;
    }

    public boolean buy(Prop prop) {
        if (prop.price() <= points) {
            exchange(prop);
            return true;
        }
        return false;
    }

    public boolean consume(Prop prop) {
        return box.remove(prop);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                points == ((Property) object).points &&
                box.equals(((Property) object).box);
    }

    private void exchange(Prop prop) {
        box.add(prop);
        points -= prop.price();
    }
}