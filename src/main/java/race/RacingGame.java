package race;

import java.util.*;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int LIMIT = 4;
    private ValueGenerator valueGenerator;
    private List<Car> cars;

    public RacingGame(String[] carNames) {
        this(carNames, new RandomValueGenerator());
    }

    public RacingGame(String[] carNames, ValueGenerator valueGenerator) {
        if (carNames.length <= 0) {
            throw new IllegalArgumentException();
        }

        cars = Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
        this.valueGenerator = valueGenerator;
    }

    public RacingResult play(int time) {
        for (int i = 0; i < time; i++) {
            run();
        }
        return makeResult();
    }

    private void run() {
        for (int i = 0; i < cars.size(); i++) {
            move(i);
        }
    }

    public void move(int index) {
        move(index, valueGenerator.generate());
    }

    public List<Car> move(int index, int randomNumber) {
        if (randomNumber >= LIMIT) {
            cars.get(index).moveFront();
        }

        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public RacingResult makeResult() {
        return new RacingResult(makeResultMap(), chooseWinners(cars));
    }

    public Map<String, Integer> makeResultMap() {
        return cars.stream().collect(Collectors.toMap(Car::getName, Car::getPosition));
    }

    public static List<String> chooseWinners(List<Car> cars) {
        Car winner = chooseWinner(cars);

        return cars.stream()
                .filter((c) -> c.isOnPosition(winner))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    static Car chooseWinner(List<Car> cars) {
        Car winner = cars.get(0);
        for (Car car : cars) {
            winner = winner.getWinner(car);
        }
        return winner;
    }

    public static int getRandomNumber() {
        return new Random().nextInt(10);
    }

    public static void main(String[] args) {
        ConsoleView consoleView = new ConsoleView();
        String[] carNames = consoleView.inputCarNames();
        int time = consoleView.inputTime();

        RacingGame racingGame = new RacingGame(carNames);

        RacingResult result = racingGame.play(time);

        consoleView.showResult(result);
    }
}
