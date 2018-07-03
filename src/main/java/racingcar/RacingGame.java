package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars;

    public RacingGame() {
        cars = new ArrayList<>();
    }

    public void settingCars(int num) {
        cars.clear();
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
            repeatDash(car.getPosition());
        }
    }

    public String repeatDash(int num) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
