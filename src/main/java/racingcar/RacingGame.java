package racingcar;

import racingcar.random.RandomGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int RANDOM_MAX_LIMIT = 10;
    private List<RacingCar> cars;
    private RandomGenerator randomGenerator;

    public RacingGame(List<RacingCar> cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public void moveCars(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars();
        }
    }

    public void moveCars() {
        for (RacingCar car : cars) {
            car.move(randomGenerator.generate(RANDOM_MAX_LIMIT));
        }
    }

    public static List<RacingCar> makeWinners(List<RacingCar> cars) {
        int maxPosition = getMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.matchBy(maxPosition))
                .collect(Collectors.toList());
    }


    private static int getMaxPosition(List<RacingCar> cars) {
        return cars.stream()
                .mapToInt(RacingCar::getPosition)
                .max()
                .orElse(0);
    }

    private String[] parseTextToCarNames(String text) {
        return text.split(",");
    }

}