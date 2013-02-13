package Player;

import Interaction.Exception;
import UI.Observer;

import java.util.HashMap;
import java.util.Map;

public class PlayerParser {
    private Map<Character, Player> stringToPlayers = new HashMap<Character, Player>();

    public PlayerParser(Observer ui) {
        stringToPlayers.put('1', new MadameChyan(new Position(0), ui));
        stringToPlayers.put('2', new UncleTuu(new Position(0), ui));
        stringToPlayers.put('3', new SunHsiaoMei(new Position(0), ui));
        stringToPlayers.put('4', new BabyKin(new Position(0), ui));
    }

    public Player get(Character number) {
        if (!stringToPlayers.containsKey(number)) {
            throw new Exception("Player number input error, please re-enter.");
        }
        return stringToPlayers.get(number);
    }
}
