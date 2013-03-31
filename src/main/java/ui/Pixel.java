package ui;

import java.util.ArrayList;
import java.util.List;

class Pixel {
    private final List<Element> elements = new ArrayList<Element>();

    public Pixel(Element element) {
        elements.add(element);
    }

    public void display() {
        elements.get(elements.size() - 1).display();
    }

    public void add(Element element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public void remove(Element element) {
        elements.remove(element);
    }

    public boolean equals(Object object) {
        return getClass() == object.getClass() &&
                elements.equals(((Pixel) object).elements);
    }
}
