package player;


import javafx.scene.control.Label;

public class Player {

    private Label pointsParClics;
    private Label reductioinCout;
    private Label nbClicsAuto;
    private Label points;

    public Player() {
        this.pointsParClics = new Label("1");
        this.reductioinCout = new Label("0");
        this.nbClicsAuto = new Label("0");
        this.points = new Label("0");
    }

    public Label getPointsParClics() {
        return pointsParClics;
    }

    public void setPointsParClics(Label pointsParClics) {
        this.pointsParClics = pointsParClics;
    }

    public Label getReductioinCout() {
        return reductioinCout;
    }

    public void setReductioinCout(Label reductioinCout) {
        this.reductioinCout = reductioinCout;
    }

    public Label getNbClicsAuto() {
        return nbClicsAuto;
    }

    public void setNbClicsAuto(Label nbClicsAuto) {
        this.nbClicsAuto = nbClicsAuto;
    }

    public Label getPoints() {
        return points;
    }

    public void setPoints(Label points) {
        this.points = points;
    }

}
