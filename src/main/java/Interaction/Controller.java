package Interaction;

import Command.CommandParser;
import Player.*;
import UI.*;


public class Controller {
    private Map map = new Map();
    private Rounder rounder;
    private CommandParser parser = new CommandParser();


    public void initialize(String input) {
        rounder = new Rounder(input, map);
    }

    public void handle(String input) {
        parser.get(input).execute(rounder.next());
        map.display();
    }

}
