package Application;

import Command.Invoker;
import Player.*;
import UI.Map;
import UI.UIException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final int PLAYER_TYPE_NUMBER = 4;
    private Map map = new Map();
    private Invoker invoker = new Invoker();

    public List<Player> players = new ArrayList<Player>(PLAYER_TYPE_NUMBER) {{
        add(new MadameChyan(new Position(0), map));
        add(new UncleTuu(new Position(0), map));
        add(new SunHsiaoMei(new Position(0), map));
        add(new BabyKin(new Position(0), map));
    }};
    public List<Player> ordered_players = new ArrayList<Player>();

    public Controller(String player_ids) {
        initializePlayerList(player_ids);
    }

    public void play() {
        map.show();
        while (true) {
            playAround();
        }
    }

    private static String waitForInputCommand() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UIException(e.toString());
        }
    }

    private void playAround() {
        for (int index = 0; index != ordered_players.size(); ++index) {
            eachPlayerRun(ordered_players.get(index));
        }
    }

    private void eachPlayerRun(Player player){
        invoker.setCommand(waitForInputCommand());
        invoker.execute(player);
        map.show();
    }

    private void initializePlayerList(String player_ids) {
        try {
            getPlayerList(player_ids);
        } catch (IndexOutOfBoundsException e) {
            throw new UIException("\nPlease input correct player numbers\n" + e.toString());
        }
    }

    private void getPlayerList(String player_ids) {
        char[] charArray = player_ids.toCharArray();
        for (int index = 0; index != charArray.length; ++index) {
            ordered_players.add(players.get(charArray[index] - '1'));
        }
    }
}
