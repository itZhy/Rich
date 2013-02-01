package UI;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.ArrayList;
import java.util.List;

public class Surface {
    private final int ROW_COUNT = 8;
    private final int COLUMNS_COUNT = 29;
    private final List<Element> elements = new ArrayList<Element>(ROW_COUNT * COLUMNS_COUNT);

    public Surface() {
        for (int index = 0; index != ROW_COUNT * COLUMNS_COUNT; ++index) {
            elements.add(new Element(' ', Ansi.Color.WHITE));
        }
    }

    public void set(int index, Element element) {
        elements.set(index, element);
    }

    public void display() {
        for (int rowIndex = 0; rowIndex != ROW_COUNT; ++rowIndex) {
            displayOneRow(rowIndex);
        }
    }

    private void displayOneRow(int rowIndex) {
        for (int columnIndex = 0; columnIndex != COLUMNS_COUNT; ++columnIndex) {
            elements.get(rowIndex * COLUMNS_COUNT + columnIndex).display();
        }
        AnsiConsole.out().print('\n');
    }
}

