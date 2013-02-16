package Player;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private final List<Role> orderedRoles = new ArrayList<Role>();
    private int currentIndex = 0;
    public Role current() {
        return orderedRoles.get(currentIndex);
    }

    public void next() {
        ++currentIndex;
        currentIndex %= orderedRoles.size();
    }

    public void add(Role role) {
        orderedRoles.add(role);
    }
}
