package Player;

import UI.UIException;
import UI.UIObserver;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Role> stringToPlayers = new HashMap<Character, Role>();

    public PlayerParser(UIObserver ui, Callback callback) {
        stringToPlayers.put('1', new MadameChyan(ui, callback));
        stringToPlayers.put('2', new UncleTuu(ui, callback));
        stringToPlayers.put('3', new SunHsiaoMei(ui, callback));
        stringToPlayers.put('4', new BabyKin(ui, callback));
    }

    public Role get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new UIException("输入的角色不存在，请重新输入。");
        }
        return stringToPlayers.get(number);
    }
}
