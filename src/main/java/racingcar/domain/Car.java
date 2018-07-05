package racingcar.domain;

import java.util.Objects;

public class Car {
    static final int MOVE_THRESHOLD = 4;

    private String name;
    private int position = 0;

    public Car(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.name = name.trim();
    }

    public Car(String name, int position) {
        this(name);
        this.position = position;
    }

    public void move(int randomNo) {
        if (randomNo >= MOVE_THRESHOLD) {
            this.position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public boolean isMaxPosition(int maxPosition) {
        return position == maxPosition;
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