package Player;

import UI.UIException;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Role> stringToPlayers = new HashMap<Character, Role>();

    public PlayerParser(Callback forwarding, Callback forwarded) {
        stringToPlayers.put('1', new MadameChyan(forwarding, forwarded));
        stringToPlayers.put('2', new UncleTuu(forwarding, forwarded));
        stringToPlayers.put('3', new SunHsiaoMei(forwarding, forwarded));
        stringToPlayers.put('4', new BabyKin(forwarding, forwarded));
    }

    public Role get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new UIException("输入的角色不存在，请重新输入。");
        }
        return stringToPlayers.get(number);
    }
}
