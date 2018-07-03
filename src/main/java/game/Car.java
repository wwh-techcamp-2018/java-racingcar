package game;

import common.Utils;

public class Car {
    public final static int FORWARD_NUM = 4;
    public final static int MINIMUM = 0;
    public final static int MAXIMUM = 10;

    private int position;
    private String name;

    public Car(String name) {
        position = 0;
        this.name = name;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    public void movePosition(int num) {
        if (num < MINIMUM || num > MAXIMUM)
            throw new IllegalStateException();
        if (num >= FORWARD_NUM)
            this.position++;
    }

    public Boolean isReached(int position) {
        return this.getPosition() == position;
    }

    public int findBiggerPosition(int position) {
        return this.position > position ? this.position : position;
    }

    @Override
    public String toString() {
        return name + " : " + Utils.dashString(position);
    }
}
