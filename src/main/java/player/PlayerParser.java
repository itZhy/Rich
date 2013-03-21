package player;

import application.GameException;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Player> stringToPlayers = new HashMap<Character, Player>();

    public PlayerParser(Callback callback) {
        stringToPlayers.put('1', new Player(Role.madameChyan, callback));
        stringToPlayers.put('2', new Player(Role.uncleTuu, callback));
        stringToPlayers.put('3', new Player(Role.SunHsiaoMei, callback));
        stringToPlayers.put('4', new Player(Role.babyKin, callback));
    }

    public Player get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new GameException("输入的角色不存在，请重新输入。", GameException.NEED_RETRY);
        }
        return stringToPlayers.get(number);
    }
}
