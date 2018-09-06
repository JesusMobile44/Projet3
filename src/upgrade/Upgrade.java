package upgrade;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Upgrade {
    Button button = new Button();
    Label description = new Label();
    Label labelCout = new Label();
    Label level = new Label();

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public Label getDescription() {
        return description;
    }

    public void setDescription(Label description) {
        this.description = description;
    }

    public Label getLabelCout() {
        return labelCout;
    }

    public void setLabelCout(Label labelCout) {
        this.labelCout = labelCout;
    }

    public Label getLevel() {
        return level;
    }

    public void setLevel(Label level) {
        this.level = level;
    }
}