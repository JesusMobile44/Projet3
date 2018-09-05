package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import player.Player;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        Player player = new Player();

        ArrayList<Button> listeUpgrade = new ArrayList<>();
        Label texteClics = new Label("Nombre de Gélibucks :");
        Label clics = new Label("0");
        Button button = new Button("C'est MR.Max");

        Button upgrade1 = new Button("1");
        Button upgrade2 = new Button("2");
        Button upgrade3 = new Button("3");
        Button upgrade4 = new Button("4");
        Button upgrade5 = new Button("5");
        listeUpgrade.add(upgrade1);
        listeUpgrade.add(upgrade2);
        listeUpgrade.add(upgrade3);
        listeUpgrade.add(upgrade4);
        listeUpgrade.add(upgrade5);

        texteClics.setScaleY(3);
        texteClics.setScaleX(2);
        clics.setScaleY(3);
        clics.setScaleX(2);
        button.setScaleX(4);
        button.setScaleY(3);

        clics.setTranslateY(50);
        clics.setTranslateX(300);
        texteClics.setTranslateY(50);
        texteClics.setTranslateX(100);
        button.setTranslateY(200);
        button.setTranslateX(300);
        for (int i=0;i<listeUpgrade.size();i++){
            listeUpgrade.get(i).setTranslateY(550);
            listeUpgrade.get(i).setTranslateX(i*100+125);
            listeUpgrade.get(i).setScaleY(2);
            listeUpgrade.get(i).setScaleX(2);
        }
        Group upgrade = new Group(upgrade1,upgrade2,upgrade3,upgrade4,upgrade5);
        Group root = new Group(texteClics,clics,button,upgrade);

        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Gelinas Clicker!");

        button.setOnAction((event ->
            clics.setText(String.valueOf(Integer.parseInt(clics.getText())+player.getPointsParClics()))
        ));
        upgrade1.setOnAction((event ->
        if(player.getPoints()>=){
            player.setPointsParClics(player.getPointsParClics()*2)
        }

        ));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
