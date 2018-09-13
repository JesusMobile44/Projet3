package upgrade;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class AutoUpgrade extends Upgrade{
    public AutoUpgrade(){
        setButton(new Button("Upgrade Auto"));
        setDescription(new Label("Achète automatiquement les améliorations"));
        setLabelCout(new Label("1000"));
        setLevel(new Label("1"));
    }
    public void ameliorer(Player player){
        button.setOnAction((event -> {
            if (Integer.parseInt(player.getPoints().getText())>=Integer.parseInt(labelCout.getText())){
                player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())-Integer.parseInt(labelCout.getText())));
                level.setText(String.valueOf(Integer.parseInt(level.getText())+1));
                player.setAutoUpgrade(true);
                labelCout.setDisable(true);
                button.setDisable(true);
            }
        }
        ));
    }
}
