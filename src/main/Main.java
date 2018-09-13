package main;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import player.*;
import upgrade.*;

import java.util.ArrayList;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    public void start(Stage primaryStage){
        Player player = new Player();

        ArrayList<Upgrade> listeUpgrade = new ArrayList<>();
        Label texteClics = new Label("Nombre de Gélibucks :");
        Button button = new Button("CLIC ME PLZ");

        PlusClics upgrade1 = new PlusClics();
        AutoClics upgrade2 = new AutoClics();
        AutoUpgrade upgrade3 = new AutoUpgrade();
        Catchphrase upgrade4 = new Catchphrase();
        BigMoney upgrade5 = new BigMoney();
        listeUpgrade.add(upgrade1);
        listeUpgrade.add(upgrade2);
        listeUpgrade.add(upgrade3);
        listeUpgrade.add(upgrade4);
        listeUpgrade.add(upgrade5);


        texteClics.setScaleY(3);
        texteClics.setScaleX(2);
        player.getPoints().setScaleY(3);
        player.getPoints().setScaleY(3);
        button.setScaleX(3);
        button.setScaleY(3);

        player.getPoints().setTranslateY(50);
        player.getPoints().setTranslateX(600);
        texteClics.setTranslateY(50);
        texteClics.setTranslateX(400);
        button.setTranslateY(300);
        button.setTranslateX(400);
        button.setPrefSize(100,50);

        upgrade4.getCatchphrase().setTranslateX(200);
        upgrade4.getCatchphrase().setTranslateY(600);
        upgrade4.getCatchphrase().setTextFill(Color.PINK);
        upgrade4.getCatchphrase().setScaleX(2);
        upgrade4.getCatchphrase().setScaleY(2);

        for (int i=0;i<listeUpgrade.size();i++){
            listeUpgrade.get(i).getButton().setTranslateX(50);
            listeUpgrade.get(i).getButton().setTranslateY(i*125+50);
            listeUpgrade.get(i).getLabelCout().setTranslateX(50);
            listeUpgrade.get(i).getLabelCout().setTranslateY(i*125+80);
            listeUpgrade.get(i).getDescription().setTranslateX(50);
            listeUpgrade.get(i).getDescription().setTranslateY(i*125+30);
        }

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1000), event1 ->{
                    player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())+Integer.parseInt(player.getNbClicsAuto().getText())));
                }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        Timeline autoUp = new Timeline(
                new KeyFrame(Duration.millis(100),event ->{
                    if (Integer.parseInt(player.getPoints().getText())>Integer.parseInt(upgrade1.getLabelCout().getText())&&player.isAutoUpgrade()==true){
                        upgrade1.getButton().fire();
                    }
                    if (Integer.parseInt(player.getPoints().getText())>Integer.parseInt(upgrade2.getLabelCout().getText())&&player.isAutoUpgrade()==true){
                        upgrade2.getButton().fire();
                    }
                }));
        autoUp.setCycleCount(Timeline.INDEFINITE);
        autoUp.play();

        Timeline bigMoney = new Timeline(
                new KeyFrame(Duration.millis(1),event -> {
                    if (player.isBigMoney()==true){
                        player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())+1));
                    }
                }));
        bigMoney.setCycleCount(Timeline.INDEFINITE);
        bigMoney.play();

        Group group1 = new Group(upgrade1.getButton(),upgrade1.getLabelCout(),upgrade1.getDescription());
        Group group2 = new Group(upgrade2.getButton(),upgrade2.getLabelCout(),upgrade2.getDescription());
        Group group3 = new Group(upgrade3.getButton(),upgrade3.getLabelCout(),upgrade3.getDescription());
        Group group4 = new Group(upgrade4.getButton(),upgrade4.getLabelCout(),upgrade4.getDescription(),upgrade4.getCatchphrase());
        Group group5 = new Group(upgrade5.getButton(),upgrade5.getLabelCout(),upgrade5.getDescription());
        Group root = new Group(texteClics,player.getPoints(),button,group1,group2,group3,group4,group5);

        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setTitle("Gelinas Clicker!");

        button.setOnAction((event ->{
            player.getPoints().setText(String.valueOf(Integer.parseInt(player.getPoints().getText())+Integer.parseInt(player.getPointsParClics().getText())*100));
            if (player.isCatchphrase()==true){
                upgrade4.getCatchphrase().setText(String.valueOf(upgrade4.getListe().get((int)(Math.random()*10))));
                upgrade4.getCatchphrase().setTextFill(Color.rgb((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256)));
            }
        }
        ));
        upgrade1.getButton().setOnAction((event ->
            upgrade1.ameliorer(player)
        ));
        upgrade2.getButton().setOnAction((event ->
            upgrade2.ameliorer(player)
        ));
        upgrade3.getButton().setOnAction((event ->
                upgrade3.ameliorer(player)
        ));
        upgrade4.getButton().setOnAction((event ->
                upgrade4.ameliorer(player)
        ));
        upgrade5.getButton().setOnAction((event ->
            upgrade5.ameliorer(player)
        ));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
