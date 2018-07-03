package racingcar;

import utility.StringUtility;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;

    public RacingGame(int num) {
        cars = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            cars.add(new Car());
        }
    }

    public void start(int times) {
        for (int i = 0; i < times; i++) {
            moveCars();
        }
    }

    public void moveCars() {
        for (Car car : cars) {
            car.moveWithCondition(getRandomNo());
        }
    }

    public int getRandomNo() {
        Random random = new Random();
        return random.nextInt(10);
    }

    public void print() {
        for (Car car : cars) {
            StringUtility.repeatDash(car.getPosition());
        }
    }
}
