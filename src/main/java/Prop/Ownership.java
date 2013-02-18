package Prop;

import java.util.HashMap;
import java.util.Map;

public class Ownership {
    private Map<String, Property> properties = new HashMap<String, Property>();

    public void add(String owner, int point) {
        initializeWhenNotExist(owner);
        properties.get(owner).add(point);
    }

    public void buy(String owner, Prop prop) {
        initializeWhenNotExist(owner);
        properties.get(owner).buy(prop);
    }

    public void consume(String owner, Prop prop) {
        initializeWhenNotExist(owner);
        properties.get(owner).consume(prop);
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() &&
                properties.equals(((Ownership)object).properties);
    }

    private void initializeWhenNotExist(String owner) {
        if (!properties.containsKey(owner)) {
            properties.put(owner, new Property());
        }
    }
}