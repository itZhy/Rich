package Player;

import Estate.BuildingObserver;
import UI.UIException;
import UI.UIObserver;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Role> stringToPlayers = new HashMap<Character, Role>();

    public PlayerParser(UIObserver ui, BuildingObserver building) {
        stringToPlayers.put('1', new MadameChyan(new Position(0), ui, building));
        stringToPlayers.put('2', new UncleTuu(new Position(0), ui, building));
        stringToPlayers.put('3', new SunHsiaoMei(new Position(0), ui, building));
        stringToPlayers.put('4', new BabyKin(new Position(0), ui, building));
    }

    public Role get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new UIException("输入的角色不存在，请重新输入。");
        }
        return stringToPlayers.get(number);
    }
}
