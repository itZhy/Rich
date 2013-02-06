package UI;

import java.util.ArrayList;
import java.util.List;

public class Pixel {
    private final List<Element> elements = new ArrayList<Element>();

    public Pixel(Element element) {
        elements.add(element);
    }

    public void display() {
        if (elements.isEmpty()) {
            throw new Exception("There isn't any element to display in one pixel.");
        }

        elements.get(elements.size() - 1).display();
    }

    public void add(Element element) {
        elements.add(element);
    }

    public void remove(Element element) {
        if (!elements.remove(element)) {
            throw new Exception("Failed to remove specific element in one pixel.");
        }
    }

    public boolean equals(Object object) {
        return object.getClass() == Pixel.class &&
                elements.equals(((Pixel) object).elements);
    }
}
