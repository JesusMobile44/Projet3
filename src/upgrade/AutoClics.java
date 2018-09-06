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
                if (level.equals("1")){
                    Timeline timeline = new Timeline(
                            new KeyFrame(Duration.millis(5000), event1 ->{
                                player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())));
                            }));
                    timeline.setCycleCount(Timeline.INDEFINITE);
                    timeline.play();
                }
                level.setText(String.valueOf(Integer.parseInt(level.getText())+1));

            }
        });
    }
}
