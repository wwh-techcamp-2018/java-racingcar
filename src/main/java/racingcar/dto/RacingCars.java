package racingcar.dto;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private List<Car> cars;
    private int maxPosition;

    public RacingCars(List<Car> cars) {
        isBlank(cars);
        this.cars = cars;
        this.maxPosition = 0;
    }

    private void isBlank(List<Car> cars) {
        if (cars == null) {
            throw new NullPointerException();
        }
        if (cars.isEmpty()) {
            throw new RuntimeException();
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinnerCars() {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isReached(maxPosition))
                winners.add(car);
        }

        return winners;
    }

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(int maxPosition) { this.maxPosition = maxPosition; }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            sb.append(car);
            sb.append('\n');
        }
        return sb.toString();
    }

}
