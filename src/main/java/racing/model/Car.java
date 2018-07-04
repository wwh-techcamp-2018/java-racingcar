package racing.model;

import java.util.Objects;

public class Car implements Comparable<Car> {
    private static final int LIMIT_NUM = 4;
    private String name;
    private int distance;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

    public int move(int num) {
        if (LIMIT_NUM <= num) {
            return ++this.distance;
        }
        return this.distance;
    }

    public boolean hasSameDistance(int max) {
        if (this.distance == max) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Car car) {
        if (this.distance < car.distance) {
            return 1;
        }
        if (this.distance == car.distance) {
            return 0;
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Car car = (Car) o;
        return distance == car.distance && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, distance);
    }
}
