package racingcar;

public class Car {
    public final static int FORWARD_NUM = 4;
    private int position;

    public Car() {
        position = 0;
    }

    public void moveWithCondition(int num) {
        if (num >= FORWARD_NUM)
            ++position;
    }

    public int getPosition() {
        return this.position;
    }
}
