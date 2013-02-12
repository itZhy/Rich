package Player;

import UI.Observer;

import java.util.ArrayList;
import java.util.List;

public class Rounder {
    private List<Player> orderedPlayers = new ArrayList<Player>();
    private int currentIndex = 0;

    public Rounder(String players, Observer observer) {
        PlayerParser parser = new PlayerParser(observer);

        for (int index = 0; index != players.length(); ++index){
            orderedPlayers.add(parser.get(players.charAt(index)));
        }
    }


    public Player next() {
        if(currentIndex == orderedPlayers.size()){
            currentIndex = 0;
        }
        return orderedPlayers.get(currentIndex++);
    }
}
