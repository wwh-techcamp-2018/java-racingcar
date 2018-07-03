package racingcar;

public class Car {
    private int position;
    private static final int LIMIT_NUM = 4;

    public Car() {
    }

    Car(int position) {
        this.position = position;
    }

    int getPosition() {
        return position;
    }

    int move(int randomValue) {
        if (randomValue > LIMIT_NUM)
            this.position++;
        return this.position;
    }

}
