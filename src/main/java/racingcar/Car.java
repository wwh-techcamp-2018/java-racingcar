package racingcar;

import utility.StringUtility;

public class Car{
    public final static int FORWARD_NUM = 4;

    private String name;
    private int position;

    public Car() {
        this("");
    }

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public void moveWithCondition(int num) {
        if (num >= FORWARD_NUM)
            ++position;
    }

    public int getPosition() {
        return this.position;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s\n", name, StringUtility.repeatDash(position));
    }
}
