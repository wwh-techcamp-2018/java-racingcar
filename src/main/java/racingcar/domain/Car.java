package racingcar.domain;

import utility.PositiveNumber;
import utility.StringUtility;

import java.util.Objects;

public class Car {

    public final static int FORWARD_NUM = 4;

    private String name;
    private PositiveNumber position;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = name;
        this.position = PositiveNumber.of(position);
    }

    public int moveWithCondition(int num) {
        if (num >= FORWARD_NUM)
            position = position.increment();
        return position.toInt();
    }

    public boolean isReached(int maxPosition) {
        return PositiveNumber.of(maxPosition).equals(position);
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.format("%s : %s", name, StringUtility.repeatDash(position.toInt()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(name, car.name) &&
                Objects.equals(position, car.position);
    }

    @Override
    public int hashCode() { return Objects.hash(name, position); }

}
