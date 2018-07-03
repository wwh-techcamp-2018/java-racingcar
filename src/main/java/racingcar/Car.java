package racingcar;

public class Car {
    private static final int LIMIT_NUM = 4;
    private int position;

    public Car() {
    }

    Car(int position) {
        this.position = position;
    }

    int getPosition() {
        return position;
    }

    int move(int randomValue) {
        if (randomValue >= LIMIT_NUM)
            this.position++;
        return this.position;
    }

}
