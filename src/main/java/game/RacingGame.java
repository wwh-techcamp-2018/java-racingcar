package game;

import common.Utils;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private int tryTime;
    private List<Car> cars;

    public RacingGame(int tryTime, String[] carOwners) {
        cars = new ArrayList<>();
        this.tryTime = tryTime;

        for (int i = 0; i < carOwners.length; i++) {
            cars.add(new Car(carOwners[i]));
        }
    }

    public int getTryTime() {
        return tryTime;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCar() {
        for (Car car : cars) {
            car.movePosition(Utils.getRandomValue());
        }
    }

    public void moveCars() {
        for (int i = 0; i < getTryTime(); i++) {
            moveCar();
        }
    }

    public List<String> trackResultWithName() {
        List<String> trackResult = new ArrayList<>();
        for (Car car : cars)
            trackResult.add(car.toString());

        return trackResult;
    }
}