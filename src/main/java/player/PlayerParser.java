package player;

import com.google.common.collect.ImmutableMap;
import utils.Checker;

public class PlayerParser {
    private final ImmutableMap<Character, Player> stringToPlayers;

    public PlayerParser(Callback callback) {
        stringToPlayers = ImmutableMap.of('1', new Player(Role.madameChyan, callback),
                '2', new Player(Role.uncleTuu, callback),
                '3', new Player(Role.SunHsiaoMei, callback),
                '4', new Player(Role.babyKin, callback));
    }

    public Player get(Character number) {
        Checker.check(stringToPlayers.containsKey(number), "输入的角色不存在，请重新输入。");
        return stringToPlayers.get(number);
    }
}
