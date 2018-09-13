package upgrade;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import main.Main;
import player.Player;

import java.util.ArrayList;

public class Catchphrase extends Upgrade{
    ArrayList<String> liste = new ArrayList();
    Label catchphrase = new Label();
    public Catchphrase(){
        setButton(new Button("Catchphrase"));
        setDescription(new Label("Nouvelles Catchphrase/clics "));
        setLabelCout(new Label("2000"));
        setLevel(new Label("1"));
        liste.add("DÉKATATOR");
        liste.add("C'est MR.Max!");
        liste.add("Gauthier, pas Dion.");
        liste.add("Juste une ptite méthode");
        liste.add("On tutois Pat");
        liste.add("MOI J'FAIS PAS LA TEUF SANS RAPH");
        liste.add("Il faut savoir mourir par les flammes");
        liste.add("Des matrices c'est juste des tableau 2D");
        liste.add("THANOS CAR");
        liste.add("Stune fois trois logicien qui rentre dans un bar...");
        catchphrase.setDisable(true);
    }

    public ArrayList<String> getListe() {
        return liste;
    }

    public void setListe(ArrayList<String> liste) {
        this.liste = liste;
    }

    public Label getCatchphrase() {
        return catchphrase;
    }

    public void setCatchphrase(Label catchphrase) {
        this.catchphrase = catchphrase;
    }

    public void ameliorer(Player player){
        button.setOnAction((event ->{
            if (Integer.parseInt(player.getPoints().getText())>=Integer.parseInt(labelCout.getText())){
                catchphrase.setText(liste.get((int)(Math.random()*10)));
                catchphrase.setDisable(false);
                player.setCatchphrase(true);
                button.setDisable(true);
                labelCout.setDisable(true);
            }
        }
        ));
    }
}
