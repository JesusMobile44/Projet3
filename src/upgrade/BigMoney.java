package upgrade;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import player.Player;

public class BigMoney extends Upgrade{
    public BigMoney(){
        setButton(new Button("Big Money"));
        setDescription(new Label("=-=!BIG!-CA$H->MONEY<-B4BY=-="));
        setLabelCout(new Label("10000"));
        setLevel(new Label("1"));
    }
    public void ameliorer(Player player){
        button.setOnAction((event -> {
            if (Integer.parseInt(player.getPoints().getText())>=Integer.parseInt(labelCout.getText())){
                player.setBigMoney(true);
                button.setDisable(true);
                labelCout.setDisable(true);
            }
        }));
    }
}
