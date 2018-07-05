package racingcar.domain;

import racingcar.dto.Entry;
import racingcar.dto.RacingGameInput;
import racingcar.dto.RacingGameResult;
import racingcar.utils.Generator;

import java.util.*;
import java.util.stream.Collectors;

public class RacingCarGame {
    private List<Car> cars = new ArrayList<>();
    private Generator generator;

    public RacingCarGame(RacingGameInput racingGameInput, Generator generator) {
        this.generator = generator;
        for (String name : racingGameInput.getNames()) {
            cars.add(CarFactory.create(name));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    private void tryMove(Car car, int numTrial) {
        for (int i = 0; i < numTrial; i++) {
            car.move(generator.generate());
        }
    }

    public RacingGameResult run(int numTrial) {
        for (Car car : cars) {
            this.tryMove(car, numTrial);
        }
        return new RacingGameResult(new Entry(cars), new Entry(getWinners()));
    }

    public List<Car> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream().filter(car -> car.isMaxPosition(maxPosition)).collect(Collectors.toList());
    }
}
