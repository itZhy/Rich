package Player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Rounder {
    private final List<Role> orderedRoles = new ArrayList<Role>();
    private int currentIndex = 0;

    public Role current() {
        return orderedRoles.get(currentIndex);
    }

    public void next() {
        do {
            ++currentIndex;
            currentIndex %= orderedRoles.size();
        } while (current().skip());
    }

    public void add(Role role) {
        orderedRoles.add(role);
    }

    public boolean delete(String account) {
        Iterator<Role> iterator = orderedRoles.iterator();
        while (iterator.hasNext()) {
            Role role = iterator.next();
            if (role.name().equals(account)) {
                iterator.remove();
            }
        }
        return (orderedRoles.size() > 1) ? true : false;
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                orderedRoles.equals(((Rounder) object).orderedRoles) &&
                currentIndex == ((Rounder) object).currentIndex;
    }
}
