package game;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_BOUND = 10;
    private List<RacingCar> cars = new ArrayList<>();

    RacingGame(String[] names) {
        for (String name : names) {
            cars.add(new RacingCar(name));
        }
    }

    void startGame(int time) {
        for (int i = 0; i < time; i++)
            rollDice();
    }

    int getRandomNum() {
        return new Random().nextInt(RANDOM_BOUND);
    }

    void rollDice() {
        for (RacingCar car : cars)
            car.moveForward(getRandomNum());
    }

    public List<RacingCar> getCars() {
        return cars;
    }


    public Set<String> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == this.getMaxPosition(cars))
                .map(RacingCar::getName)
                .collect(Collectors.toSet());
    }

    int getMaxPosition(List<RacingCar> cars) {
        return Collections.max(cars, Comparator.comparingInt(RacingCar::getPosition)).getPosition();
    }
}