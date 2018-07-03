package racingcar;

import utility.StringUtility;

import java.util.Random;

public class Car {
    public final static int FORWARD_NUM = 4;

    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public int move() {
        return moveWithCondition(getRandomNo());
    }

    public int moveWithCondition(int num) {
        if (num >= FORWARD_NUM)
            ++position;
        return position;
    }

    public boolean isReached(int maxPosition) {
        return maxPosition == position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", name, StringUtility.repeatDash(position));
    }

    public int getRandomNo() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
