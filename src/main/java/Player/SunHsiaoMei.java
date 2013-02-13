package Player;

import UI.Element;
import UI.Observer;
import org.fusesource.jansi.Ansi;

public class SunHsiaoMei extends Player {
    private Observer ui;

    public SunHsiaoMei(Position initialPosition, Observer ui) {
        super(initialPosition);
        this.ui = ui;
    }

    public boolean equals(Object object)    {
        return super.equals(object) && ui.equals(((SunHsiaoMei)object).ui);
    }

    public void showPromptMessage() {
        System.out.print("孙美美>");
    }

    protected void updateUI(Position source, Position destination) {
        ui.move(source, destination, new Element('S', Ansi.Color.YELLOW));
    }
}
