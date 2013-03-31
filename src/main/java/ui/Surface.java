package ui;

import org.fusesource.jansi.AnsiConsole;

import java.util.ArrayList;
import java.util.List;

import static org.fusesource.jansi.Ansi.ansi;

class Surface {
    private final int ROW_COUNT = 8;
    private final int COLUMNS_COUNT = 29;
    private final List<Pixel> pixels = new ArrayList<Pixel>(ROW_COUNT * COLUMNS_COUNT);

    public Surface() {
        for (int index = 0; index != ROW_COUNT * COLUMNS_COUNT; ++index) {
            pixels.add(new Pixel(new Element(' ')));
        }
    }

    public void add(int index, Element element) {
        pixels.get(index).add(element);
    }

    public void remove(int index, Element element) {
        pixels.get(index).remove(element);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                pixels.equals(((Surface) object).pixels);
    }

    public void display() {
        AnsiConsole.out.print(ansi().eraseScreen());
        for (int rowIndex = 0; rowIndex != ROW_COUNT; ++rowIndex) {
            displayOneRow(rowIndex);
        }
    }

    private void displayOneRow(int rowIndex) {
        for (int columnIndex = 0; columnIndex != COLUMNS_COUNT; ++columnIndex) {
            pixels.get(rowIndex * COLUMNS_COUNT + columnIndex).display();
        }
        AnsiConsole.out().print('\n');
    }
}