package game;

public class RacingCar {
    private static final int FORWARD_NUM = 4;
    private int position = 0;
    private String name;

    public RacingCar(String name) {
        this.name = name;
    }

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    int isWinner() {
        return position;
    }

    void moveForward(int randomNum) {
        if (randomNum >= FORWARD_NUM) ++this.position;
    }

    String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return this.position == maxPosition;
    }
}