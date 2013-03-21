package player;

import application.GameException;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Role> stringToPlayers = new HashMap<Character, Role>();

    public PlayerParser(Callback callback) {
        stringToPlayers.put('1', new Role(Feature.MADAME_CHYAN, callback));
        stringToPlayers.put('2', new Role(Feature.UNCLE_TUU, callback));
        stringToPlayers.put('3', new Role(Feature.SUN_HSIAO_MEI, callback));
        stringToPlayers.put('4', new Role(Feature.BABY_KIN, callback));
    }

    public Role get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new GameException("输入的角色不存在，请重新输入。", GameException.NEED_RETRY);
        }
        return stringToPlayers.get(number);
    }
}
