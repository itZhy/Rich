package Display;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class UI {
    public static void main(String args[]) {
        new UI().show();
    }

    public void show() {
        AnsiConsole.out.println(ansi().eraseScreen().fg(Ansi.Color.RED).a("Hello").fg(Ansi.Color.GREEN).a(" World").reset());
    }
}
