package Interaction;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Interaction {

    public void run() {
        Controller controller = new Controller();

        try {
            controller.initialize(waitForInputCommand());
        } catch (Exception e) {
        }
        while (true) {
            try {
                controller.handle(waitForInputCommand());
            } catch (Exception e) {

            }
        }

    }

    private static String waitForInputCommand() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new UI.Exception(e.toString());
        }
    }
}
