package racingcar;

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

    public int getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(int maxPosition) {
        this.maxPosition = maxPosition;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Car car : cars) {
            sb.append(car.toString());
        }
        return sb.toString();
    }
}
