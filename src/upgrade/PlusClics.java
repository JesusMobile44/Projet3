package upgrade;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class PlusClics extends Upgrade {
    public PlusClics(){
        setButton(new Button("Clics +++"));
        setDescription(new Label("Augmente les points/clics"));
        setLabelCout(new Label("50"));
        setLevel(new Label("1"));

    }

    public void ameliorer(Player player) {
        button.setOnAction((event ->{
            if (Integer.parseInt(player.getPoints().getText())>=Integer.parseInt(labelCout.getText())){
                player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())-Integer.parseInt(labelCout.getText())));
                labelCout.setText(String.valueOf(Integer.parseInt(labelCout.getText())*2));
                level.setText(String.valueOf(Integer.parseInt(level.getText())+1));
                player.getPointsParClics().setText(String.valueOf(Integer.parseInt(player.getPointsParClics().getText())+1));
            }
        }
        ));

    }
}
