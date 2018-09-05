package player;

public class Player {
    int pointsParClics = 1;
    int reductioinCout = 0;
    int nbClicsAuto = 0;
    int points = 0;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointsParClics() {
        return pointsParClics;
    }

    public void setPointsParClics(int pointsParClics) {
        this.pointsParClics = pointsParClics;
    }

    public int getReductioinCout() {
        return reductioinCout;
    }

    public void setReductioinCout(int reductioinCout) {
        this.reductioinCout = reductioinCout;
    }

    public int getNbClicsAuto() {
        return nbClicsAuto;
    }

    public void setNbClicsAuto(int nbClicsAuto) {
        this.nbClicsAuto = nbClicsAuto;
    }
}
