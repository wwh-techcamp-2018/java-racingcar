package racingcar.controller;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {

    public static int getMaxPosition(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    public static List<Car> getWinners(List<Car> cars) {
        return getWinners(cars, getMaxPosition(cars));
    }

    private static List<Car> getWinners(List<Car> cars, int maxPosition) {
        return cars.stream().filter(car -> car.isWinner(maxPosition)).collect(Collectors.toList());
    }

    public static String[] splitNames(String names) {
        return names.trim().split(",");
    }

    public void race(List<Car> cars, int tryCount) {

    }
}
