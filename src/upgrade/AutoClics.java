package upgrade;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;
import player.Player;

public class AutoClics extends Upgrade{
    public AutoClics() {
        setButton(new Button("Clics Auto"));
        setDescription(new Label("Augmente les points/secondes"));
        setLabelCout(new Label("100"));
        setLevel(new Label("1"));
    }
    public void ameliorer(Player player){
        button.setOnAction(event ->{
            if (Integer.parseInt(player.getPoints().getText())>=Integer.parseInt(labelCout.getText())){
                player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())-Integer.parseInt(labelCout.getText())));
                labelCout.setText(String.valueOf(Integer.parseInt(labelCout.getText())*2));
                level.setText(String.valueOf(Integer.parseInt(level.getText())+1));
                player.getNbClicsAuto().setText(String.valueOf(Integer.parseInt(player.getNbClicsAuto().getText())+1));
            }
        });
    }
}
