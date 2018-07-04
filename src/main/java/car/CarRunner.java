package car;

import car.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRunner<T extends Car> {

    private static final int RANDOM_BOUND_NUM = 10;

    protected List<T> cars;

    public CarRunner(List<T> cars){
        this.cars = cars;
    }

    public void run(int numOfGames) {
        for (int i = 0; i < numOfGames; i++) {
            moveCars();
        }
    }

    void moveCars() {
        for (Car car : cars) {
            car.move(getRandomNum());
        }
    }

    int getRandomNum() {
        return new Random().nextInt(RANDOM_BOUND_NUM);
    }

    List<Integer> getPositions() {
        List<Integer> result = new ArrayList<Integer>(cars.size());
        for (Car car : cars) {
            result.add(car.getPosition());
        }
        return result;
    }

}
