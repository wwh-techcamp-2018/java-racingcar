package racing;

import racing.common.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGameManager {
    private List<Car> cars;

    public RacingGameManager() {
        cars = new ArrayList<>();
    }

    public int initGame(int carNum) {
        for (int i = 0; i < carNum; i++) {
            cars.add(new Car());
        }
        return cars.size();
    }

    private int getRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }

    private int moveCar(int count, Car car) {
        for (int i = 0; i < count; i++) {
            car.move(getRandomNum());
        }
        return car.getDistance();
    }

    private void moveCars(int count) {
        for (Car car : cars) {
            moveCar(count, car);
        }
    }

    private void print(String dash) {
        System.out.println(dash);
    }

    private void printResult() {
        for (int i = 0; i < cars.size(); i++) {
            print(StringUtils.createDash(cars.get(i).getDistance()));
        }
    }

    public void runGame(int count) {
        moveCars(count);
        printResult();
    }

}
