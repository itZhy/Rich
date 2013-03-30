package utils;

import application.GameException;

public class Checker {
    static public void check(boolean express, String message) {
        if (!express) {
            throw new GameException(message);
        }
    }
}
