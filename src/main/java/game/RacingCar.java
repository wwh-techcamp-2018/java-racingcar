package game;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    int getPosition() {
        return position;
    }

    int moveForward(int randomNum) {
        if (randomNum >= FORWARD_NUM) return ++this.position;

        return getPosition();
    }

    String getName() {
        return name;
    }
}