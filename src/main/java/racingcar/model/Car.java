package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Car {
    private static final int LIMIT_NUM = 4;
    private static final String LOAD = "-";
    private int position;
    private String name;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.position = position;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int move(int randomValue) {
        if (randomValue >= LIMIT_NUM)
            this.position++;
        return this.position;
    }

    public int getMaxPosition(int maxPosition) {
        return (maxPosition > position) ? maxPosition : position;
    }

    public boolean isSame(int max) {
        return this.position == max;
    }

    public String getRoad() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position; i++) {
            sb.append(LOAD);
        }
        return sb.toString();
    }

//    public List<String> pushYourName(List<Car>)

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

        return Objects.hash(position, name);
    }

    @Override
    public String toString() {
        return "Car{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
