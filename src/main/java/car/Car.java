package car;

import java.util.Random;

public class Car {

    private int position;

    public Car() {
        position = 0;
    }

    int move(int nextMove) {
        if (nextMove >= 4) {
            return ++position;
        }
        return position;
    }

    int getPosition() {
        return this.position;
    }
}
