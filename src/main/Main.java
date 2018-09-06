package main;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import player.*;
import upgrade.AutoClics;
import upgrade.PlusClics;
import upgrade.Upgrade;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        Player player = new Player();

        ArrayList<Upgrade> listeUpgrade = new ArrayList<>();
        Label texteClics = new Label("Nombre de Gélibucks :");
        Button button = new Button("C'est MR.Max");

        PlusClics upgrade1 = new PlusClics();
        AutoClics upgrade2 = new AutoClics();
        Button upgrade3 = new Button("3");
        Button upgrade4 = new Button("4");
        Button upgrade5 = new Button("5");
        listeUpgrade.add(upgrade1);
        listeUpgrade.add(upgrade2);
        /*listeUpgrade.add(upgrade3);
        listeUpgrade.add(upgrade4);
        listeUpgrade.add(upgrade5);
        */
        texteClics.setScaleY(3);
        texteClics.setScaleX(2);
        player.getPoints().setScaleY(3);
        player.getPoints().setScaleY(2);
        button.setScaleX(4);
        button.setScaleY(3);


        player.getPoints().setTranslateY(50);
        player.getPoints().setTranslateX(300);
        texteClics.setTranslateY(50);
        texteClics.setTranslateX(100);
        button.setTranslateY(200);
        button.setTranslateX(300);
        button.setPrefSize(100,50);

        upgrade1.getLabelCout().setTranslateX(50);
        upgrade1.getLabelCout().setTranslateY(580);
        for (int i=0;i<listeUpgrade.size();i++){
            listeUpgrade.get(i).getButton().setTranslateX(i*125+50);
            listeUpgrade.get(i).getButton().setTranslateY(550);
            listeUpgrade.get(i).getLabelCout().setTranslateX(i*125+50);
            listeUpgrade.get(i).getLabelCout().setTranslateY(580);
            listeUpgrade.get(i).getDescription().setTranslateX(i*125+50);
            listeUpgrade.get(i).getDescription().setTranslateY(530);
            /*listeUpgrade.get(i).getButton().setScaleY(2);
            listeUpgrade.get(i).getButton().setScaleX(2);
            listeUpgrade.get(i).getLabelCout().setScaleY(2);
            listeUpgrade.get(i).getLabelCout().setScaleX(2);
            listeUpgrade.get(i).getDescription().setScaleY(2);
            listeUpgrade.get(i).getDescription().setScaleX(2);*/
        }
        //Group upgrade = new Group(upgrade1,upgrade2,upgrade3,upgrade4,upgrade5);
        Group group1 = new Group(upgrade1.getButton(),upgrade1.getLabelCout(),upgrade1.getDescription());
        Group group2 = new Group(upgrade2.getButton(),upgrade2.getLabelCout(),upgrade2.getDescription());
        Group root = new Group(texteClics,player.getPoints(),button,group1,group2);

        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Gelinas Clicker!");

        button.setOnAction((event ->
            player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())+Integer.parseInt(player.getPointsParClics().getText())))
        ));
        upgrade1.getButton().setOnAction((event ->
            upgrade1.ameliorer(player)
        ));
        upgrade2.getButton().setOnAction((event ->
            upgrade2.ameliorer(player)
        ));

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
