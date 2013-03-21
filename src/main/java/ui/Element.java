package ui;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import static org.fusesource.jansi.Ansi.ansi;

public class Element {
    private final char symbol;
    private final Ansi.Color color;

    public Element(char symbol, Ansi.Color color) {
        this.symbol = symbol;
        this.color = color;
    }

    public void display() {
        AnsiConsole.out.print(ansi().bg(Ansi.Color.BLACK).fg(color).a(symbol).reset());
    }

    public Element dye(char symbol)    {
        return new Element(symbol, color);
    }

    public boolean equals(Object object)    {
        return getClass() == object.getClass()&&
                symbol == ((Element) object).symbol &&
                color.equals(((Element) object).color);
    }
}
