package prop;

import player.Role;

import java.util.HashMap;
import java.util.Map;

class Ownership {
    private final Map<Role, Property> properties = new HashMap<Role, Property>();

    public void add(Role owner, int point) {
        initializeWhenNotExist(owner);
        properties.get(owner).add(point);
    }

    public void buy(Role owner, Prop prop) {
        initializeWhenNotExist(owner);
        properties.get(owner).buy(prop);
    }

    public void sell(Role owner, Prop prop) {
        initializeWhenNotExist(owner);
        properties.get(owner).sell(prop);
    }

    public void consume(Role owner, Prop prop) {
        initializeWhenNotExist(owner);
        properties.get(owner).consume(prop);
    }

    public String query(Role owner) {
        initializeWhenNotExist(owner);
        return properties.get(owner).query();
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                properties.equals(((Ownership) object).properties);
    }

    private void initializeWhenNotExist(Role owner) {
        if (!properties.containsKey(owner)) {
            properties.put(owner, new Property());
        }
    }
}