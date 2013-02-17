package Player;

import UI.UIException;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Role> stringToPlayers = new HashMap<Character, Role>();

    public PlayerParser(Callback callback) {
        stringToPlayers.put('1', new MadameChyan(callback));
        stringToPlayers.put('2', new UncleTuu(callback));
        stringToPlayers.put('3', new SunHsiaoMei(callback));
        stringToPlayers.put('4', new BabyKin(callback));
    }

    public Role get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new UIException("输入的角色不存在，请重新输入。");
        }
        return stringToPlayers.get(number);
    }
}
