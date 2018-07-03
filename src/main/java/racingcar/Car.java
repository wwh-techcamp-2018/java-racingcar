package racingcar;

public class Car {
    public static final int FORWARD_NUM = 4;
    private int position;

    public Car() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public int move(int randomNo) {
        //forward when more than 4
        if (randomNo >= FORWARD_NUM) {
            return position++;
        }
        return position;
    }
}
