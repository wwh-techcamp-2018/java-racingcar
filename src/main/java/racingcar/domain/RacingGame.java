package racingcar.domain;

import racingcar.dto.RacingCars;
import utility.PositiveNumber;
import utility.RandomGenerator;
import utility.StringUtility;

import java.util.*;

public class RacingGame {

    private static final int DEFAULT_BOUND = 10;

    private RacingCars racingCars;

    public RacingGame(String input) {
        this.racingCars = new RacingCars(initCars(input));
    }

    private static List<Car> initCars(String input) {
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
        int positiveTimes = PositiveNumber.of(times).toInt();
        for (int i = 0; i < positiveTimes; i++) {
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

    public RacingCars getRacingCars() {
        return racingCars;
    }

}
