package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Generator;
import racingcar.model.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public int getMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public List<Car> getWinners() {
        return getWinners(getMaxPosition());
    }

    private List<Car> getWinners(int maxPosition) {
        return cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
    }

    public static String[] splitNames(String names) {
        return names.trim().split(",");
    }

    public void race(int tryCount) {
        RandomGenerator rg = new RandomGenerator();
        for (int i = 0; i < tryCount; i++) {
            moveCars(rg);
        }
    }

    public void moveCars(Generator generator) {
        for (Car car : cars) {
            car.move(generator.generate());
        }
    }
}
