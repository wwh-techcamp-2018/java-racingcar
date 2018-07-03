package game;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private int position = 0;

    public int getPosition() {
        return position;
    }

    public int moveForward(int randomNum) {
        if (randomNum >= FORWARD_NUM)
            return ++this.position;

        return getPosition();
    }
}
