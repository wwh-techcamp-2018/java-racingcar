package racingcar;

import utility.RandomGenerator;
import utility.StringUtility;

import java.util.*;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;

    private RacingCars racingCars;

    public RacingGame(String input) {
        this(new RacingCars(initCar(input)));
    }

    public RacingGame(RacingCars racingCars) {
        this.racingCars = racingCars;
    }

    private static List<Car> initCar(String input) {
        isBlank(input);
        return createCars(StringUtility.splitWithComma(input));
    }

    private static void isBlank(String input) {
        if (null == input) {
            throw new NullPointerException();
        }
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Car> createCars(String[] names) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            cars.add(new Car(names[i]));
        }
        return cars;
    }

    public void run(int times) {
        if (times < 1) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < times; i++) {
            moveCars();
        }
    }

    private void moveCars() {
        List<Car> cars = racingCars.getCars();
        for (Car car : cars) {
            int position = car.moveWithCondition(RandomGenerator.generate(DEFAULT_BOUND));
            updateMaxPosition(position);
        }
    }

    private void updateMaxPosition(int position) {
        racingCars.setMaxPosition(Math.max(racingCars.getMaxPosition(), position));
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<Car>();

        List<Car> cars = racingCars.getCars();
        int maxPosition = racingCars.getMaxPosition();
        for (Car car : cars) {
            if (car.isReached(maxPosition))
                winners.add(car);
        }

        return winners;
    }

    public RacingCars getRacingCars() {
        return racingCars;
    }

}
