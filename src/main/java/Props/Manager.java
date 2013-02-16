package Props;

import Player.Role;

import java.util.HashMap;
import java.util.Map;

public class Manager {
    private Map<String, Property> properties = new HashMap<String, Property>();

    public void add(Role role, int point) {
        initializeWhenNotExist(role);
        properties.get(role.name()).add(point);
    }

    private void initializeWhenNotExist(Role role)  {
        if (!properties.containsKey(role.name()))    {
             properties.put(role.name(), new Property());
        }
    }

    public void buy(Role role, Prop prop) {
        initializeWhenNotExist(role);
        properties.get(role.name()).buy(prop);
    }

    public boolean consume(Role role, Prop prop) {
        initializeWhenNotExist(role);
        return properties.get(role.name()).consume(prop);
    }
}

