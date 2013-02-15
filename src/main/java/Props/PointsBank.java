package Props;

import Player.Role;

import java.util.HashMap;
import java.util.Map;

public class PointsBank {
    private final Map<String, Integer> points = new HashMap<String, Integer>();

    public void add(Role role, int point) {
        openAccountWhenNotExist(role);
        points.put(role.name(), points.get(role.name()) + point);
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass() && points.equals(((PointsBank)object).points);
    }
    
    private void openAccountWhenNotExist(Role role)  {
        if (!points.containsKey(role.name()))    {
             points.put(role.name(), 0);
        }
    }
}
