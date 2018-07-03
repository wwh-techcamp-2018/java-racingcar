package car;

import car.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClientRunner {
    List<Car> cars;
    ClientRunner(List<Car> cars){
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
        return new Random().nextInt(10);
    }

    List<Integer> getPositions() {
        List<Integer> result = new ArrayList<Integer>(cars.size());
        for (Car car : cars) {
            result.add(car.getPosition());
        }
        return result;
    }

}
