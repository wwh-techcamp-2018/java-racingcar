package racingcar;

import utility.StringUtility;

import java.util.Objects;
import java.util.Random;

public class Car {

    public final static int FORWARD_NUM = 4;

    private String name;
    private int position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position &&
                Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
