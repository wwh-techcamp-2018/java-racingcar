package car.model;

import car.domain.CarDTO;

import java.util.Objects;
import java.util.Random;

public class Car {
    static final int DETERMINANT = 4;

    private int position;

    public Car() {
        position = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public int move(int nextMove) {
        if (nextMove >= DETERMINANT) {
            return ++position;
        }
        return position;
    }

    public int getPosition() {
        return this.position;
    }

    public CarDTO createCarDTO(){
        return new CarDTO(position);
    }

}
