package Player;

import UI.UIException;
import UI.Observer;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private final Map<Character, Player> stringToPlayers = new HashMap<Character, Player>();

    public PlayerParser(Observer ui) {
        stringToPlayers.put('1', new MadameChyan(new Position(0), ui));
        stringToPlayers.put('2', new UncleTuu(new Position(0), ui));
        stringToPlayers.put('3', new SunHsiaoMei(new Position(0), ui));
        stringToPlayers.put('4', new BabyKin(new Position(0), ui));
    }

    public Player get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new UIException("输入的角色不存在，请重新输入。");
        }
        return stringToPlayers.get(number);
    }
}
